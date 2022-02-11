/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.appmanager;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.somecompany.config.AppConfig;
import ru.somecompany.desktop.utils.Constants;
import ru.somecompany.server.service.ExecutedBatService;
import ru.somecompany.server.service.FSService;
import ru.somecompany.server.service.ParametersService;
import ru.somecompany.server.service.ServerResourceService;

/**
 *
 * @author Alexandra
 */
public class Startup {

    private static final Logger logger = LoggerFactory.getLogger(Startup.class);
    private final static ScheduledExecutorService schedulerChecker = Executors.newScheduledThreadPool(2);
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private static String appName = "";

    private static Integer updaterPort = Constants.EUC_UPDATER_PORT;
    private static Integer appPort = Constants.EUC_PORT;
    private static String pngName = "egais.png";

    static char[] b = new char[]{
        0x36, 0x62, 0x36,
        0x31, 0x63, 0x32,
        0x32, 0x33, 0x2d,
        0x61, 0x39, 0x33,
        0x36, 0x2d, 0x34,
        0x37, 0x62, 0x31,
        0x2d, 0x38, 0x62,
        0x35, 0x63, 0x2d,
        0x37, 0x32, 0x63,
        0x33, 0x39, 0x63,
        0x32, 0x31, 0x38,
        0x39, 0x66, 0x38};

    private static TrayIcon trayIcon;
    private static MenuItem updateItem;
    private static MenuItem startItem;
    private static MenuItem stopItem;
    private static MenuItem stateItem;
    private static AppServiceFrame frame;

    private static boolean isAppStarted = false;
    private static boolean needToUpdateApp = false;
    private static String additionalProblems = "";

    private static Map<String, File> files = new HashMap<>();

    private static void updateState() {

        stateItem.setLabel("Сервис работает");
        String text = "<ul>";
        frame.setAppStarted(isAppStarted);
        startItem.setEnabled(!isAppStarted);
        stopItem.setEnabled(isAppStarted);
        if (isAppStarted) {
            text += "<li>Сервис " + appName + " запущен</li>";
        } else {
            text += "<li>Сервис " + appName + " остановлен</li>";
            stateItem.setLabel("Сервис остановлен!");
        }

        if (needToUpdateApp) {
            text += "<li> Программма требует обновления. Это займет пару минут. Выберите \"Обновить\"</li>";
            stateItem.setLabel("Необходимо обновить!");

            updateItem.setEnabled(true);
            if (frame != null) {
                frame.setUpdateEnabled(true);
            }
        } else {
            updateItem.setEnabled(false);
            if (frame != null) {
                frame.setUpdateEnabled(false);
            }
        }
        if (!additionalProblems.isEmpty()) {
            stateItem.setLabel("Не настроено подключение!");
            text += "<li>" + additionalProblems + "</li>";
        }
        text += "</ul>";
        frame.setState(text);
    }

    private static Properties loadProps() throws FileNotFoundException, IOException {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPasswordCharArray(b);
        encryptor.initialize();
        Properties props = new EncryptableProperties(encryptor);
        props.load(new FileInputStream("conf.pr"));
        return props;
    }

    private static boolean update(AnnotationConfigApplicationContext context) {

        frame.setState("Обновление приложения...");
        stateItem.setLabel("Обновление приложения...");
        FSService fSService = context.getBean(FSService.class);
        if (fSService.updateFiles()) {
            File file = new File("downloaded.txt");
            if (file.exists()) {
                File file1 = new File("hash.txt");
                if (file1.exists()) {
                    file1.delete();
                }
                file.renameTo(file1);
            }
            needToUpdateApp = false;
            updateState();
            return true;
        }
        return false;
    }

    private static void checkIsAppStarted(AnnotationConfigApplicationContext context) {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    //sh, utm
                    ServerSocket serverSocket = new ServerSocket(appPort, 0, InetAddress.getLoopbackAddress());
                    serverSocket.close();
                    isAppStarted = false;
                } catch (IOException ex) {
                    isAppStarted = true;
                } finally {
                    updateState();
                }
            }
        }, 15, 15, TimeUnit.SECONDS);
    }

    private static boolean checkNeedToUpdate(AnnotationConfigApplicationContext context) {
        needToUpdateApp = false;
        logger.info("App Updater Service for " + appName + " checking for update module");

        FSService fSService = context.getBean(FSService.class);
        ParametersService parametersService = context.getBean(ParametersService.class);
        ServerResourceService serverResourceService = context.getBean(ServerResourceService.class);

        String currentHash = fSService.getCurrentVersionHash();
        String remoteHash = serverResourceService.getHash();

        logger.info("Compare hash of working version:" + currentHash + " and from server: " + remoteHash);
        if (remoteHash != null) {
            if (currentHash == null || !currentHash.equalsIgnoreCase(remoteHash)) {
                logger.info("Hash differs: checking if resource has been already downloaded ");

                String downloadedHash = fSService.getDownloadedVersionHash();
                if (downloadedHash == null || !downloadedHash.equalsIgnoreCase(remoteHash)) {

                    logger.info("Need to download " + parametersService.getResourceName());
                    serverResourceService.downloadFile();
                    fSService.updateDownloadedHash(remoteHash);
                }
                needToUpdateApp = true;
            }
        }

        return needToUpdateApp;

    }

    private static void blockResource() {
        scheduler.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(updaterPort);
                    serverSocket.accept();
                    System.exit(0);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Один экземпляр сервиса обновления" + appName + " уже запущен! ",
                            "Ошибка!",
                            JOptionPane.WARNING_MESSAGE);
                    logger.error(ex.getMessage(), ex);
                    System.exit(0);
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }

            }
        });
    }

    public static void initGui(final AnnotationConfigApplicationContext context) {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            // handle exception
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartActionListener startActionListener = new StartActionListener(context);
                StopActionListener stopActionListener = new StopActionListener(context);
                RestartActionListener restartActionListener = new RestartActionListener(context);
                UpdateActionListener updateActionListener = new UpdateActionListener(context);
                ExitActionListener exitActionListener = new ExitActionListener(context);
                frame = new AppServiceFrame(startActionListener, stopActionListener, restartActionListener, updateActionListener, exitActionListener);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setTitle(appName);
                Image image;
                try {
                    image = ImageIO.read(Startup.class.getResource(pngName));
                    frame.setIconImage(image);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.addWindowListener(new WindowListener() {

                    @Override
                    public void windowActivated(WindowEvent arg0) {
                        // TODO Auto-generated method stub  

                    }

                    @Override
                    public void windowClosed(WindowEvent arg0) {
                        frame.setVisible(false);

                    }

                    @Override
                    public void windowClosing(WindowEvent arg0) {
                        frame.setVisible(false);

                    }

                    @Override
                    public void windowDeactivated(WindowEvent arg0) {
                        // TODO Auto-generated method stub  

                    }

                    @Override
                    public void windowDeiconified(WindowEvent arg0) {
                        // TODO Auto-generated method stub  

                    }

                    @Override
                    public void windowIconified(WindowEvent arg0) {
                        frame.setVisible(false);

                    }

                    @Override
                    public void windowOpened(WindowEvent arg0) {
                        // TODO Auto-generated method stub  

                    }

                });
            }
        });
    }

    public static void createScripts(final AnnotationConfigApplicationContext context, Properties props) {
        try {
            File folder = new File("./scripts");
            folder.mkdir();

            ParametersService parametersService = context.getBean(ParametersService.class);
            String jarName = parametersService.getJarName();
            String folderName = parametersService.getResourceName().replace(".zip", "");
            String startScriptName = folderName + "_start";

            String cred = props.getProperty("cred");
            String url = props.getProperty("url");

            String startAppScript = "start /d .\\"
                    + folderName + " ..\\jre\\bin\\javaw -Dfile.encoding=UTF-8 -jar ..\\"
                    + folderName + "\\" + jarName + " start  -u " + url + " -l " + cred;

            File file = new File("./scripts/" + startScriptName + ".bat");
            file.createNewFile();
            FileUtils.writeStringToFile(file, startAppScript, "UTF-8");

            String stopScriptName = folderName + "_stop";
            String stopAppScript = "start /d .\\"
                    + folderName + " ..\\jre\\bin\\javaw -Dfile.encoding=UTF-8 -jar ..\\"
                    + folderName + "\\" + jarName + " stop";

            File file2 = new File("./scripts/" + stopScriptName + ".bat");
            file2.createNewFile();
            FileUtils.writeStringToFile(file2, stopAppScript, "UTF-8");

            files.put("start", file);
            files.put("stop", file2);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }

    }

    private static void stopUpdater() throws IOException {

        logger.info("Try to stop from external");
        Socket socket = new Socket(InetAddress.getLoopbackAddress(), updaterPort);
        socket.getInputStream();
    }

    private static void startUpdater() {
        blockResource();

        PropertyConfigurator.configure(Startup.class.getClassLoader().getResourceAsStream("log4j.properties"));
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ParametersService parametersService = context.getBean(ParametersService.class);
        appName = parametersService.getReadableName();

        logger.info("App Updater Service is started");

        initGui(context);
        putToTray(context);
        schedulerChecker.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                if (checkNeedToUpdate(context)) {
                    trayIcon.displayMessage("Доступно обновление!", "Рекомендуется обновить " + appName, TrayIcon.MessageType.INFO);
                    updateState();
                }
            }
        }, 30, 30, TimeUnit.SECONDS);

        if (checkNeedToUpdate(context)) {
            update(context);
        }
        startApp(context);
        checkIsAppStarted(context);
    }

    public static void main(String[] args) {

        logger.info("App Updater Service is started");
        String command = args.length > 0 ? args[0] : "start";
        logger.info("command is {}", command);
        try {
            switch (command) {
                case "start": {
                    startUpdater();
                    break;
                }
                case "stop": {
                    stopUpdater();
                    break;
                }
                default: {
                    startUpdater();
                }
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }

    }

    private static void putToTray(final AnnotationConfigApplicationContext context) {

        try {

            logger.info("Put to tray");
            if (!SystemTray.isSupported()) {
                logger.warn("System tray is not supported !!! ");
                return;
            }
            SystemTray systemTray = SystemTray.getSystemTray();

            Image image = ImageIO.read(Startup.class.getResource("egais.png"));

            PopupMenu trayPopupMenu = new PopupMenu();
            stateItem = new MenuItem();
            stateItem.setLabel("Инициализация...");
            trayPopupMenu.add(stateItem);

            MenuItem item = new MenuItem("Развернуть");
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);
                    frame.setExtendedState(JFrame.NORMAL);
                }
            });
            if (frame != null) {
                trayPopupMenu.add(item);
                trayPopupMenu.addSeparator();
            }

            updateItem = new MenuItem("Обновить");
            updateItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    stopApp(context);
                    update(context);
                    startApp(context);
                }
            });
            updateItem.setEnabled(false);
            trayPopupMenu.add(updateItem);

            trayPopupMenu.addSeparator();

            startItem = new MenuItem("Запустить");
            startItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    startApp(context);
                }
            });
            trayPopupMenu.add(startItem);

            MenuItem action = new MenuItem("Перезапустить");
            action.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopApp(context);
                    startApp(context);
                }
            });
            trayPopupMenu.add(action);

            stopItem = new MenuItem("Остановить");
            stopItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopApp(context);
                }
            });
            trayPopupMenu.add(stopItem);

            trayPopupMenu.addSeparator();
            MenuItem exit = new MenuItem("Выход");
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isAppStarted) {
                        stopApp(context);
                    }
                    System.exit(0);
                }
            });
            trayPopupMenu.add(exit);

            //setting tray icon
            trayIcon = new TrayIcon(image, appName, trayPopupMenu);
            trayIcon.setImageAutoSize(true);

            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (frame != null) {
                        frame.setVisible(true);
                        frame.setExtendedState(JFrame.NORMAL);
                    }
                }

            });

            try {
                systemTray.add(trayIcon);
            } catch (AWTException awtException) {
                logger.error(awtException.getMessage(), awtException);
            }

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void startApp(final AnnotationConfigApplicationContext context) {

        frame.setState("Запуск сервиса...");
        stateItem.setLabel("Запуск сервиса...");
        additionalProblems = "";
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {

        }
        //final ExecutedJarService jarService = context.getBean(ExecutedJarService.class);
        final ExecutedBatService batService = context.getBean(ExecutedBatService.class);
        Properties props = null;
        try {
            props = loadProps();
            createScripts(context, props);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Конфигурационный файл для настройки подключения " + appName + " не загружен.",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE);
            additionalProblems = "Конфигурационный файл для настройки подключения " + appName + " не загружен";
            updateState();
        }
        if (props != null) {
            batService.executeBat(files.get("start"));
            //jarService.start(props);

        }
    }

    public static void stopApp(final AnnotationConfigApplicationContext context) {
        //final ExecutedJarService jarService = context.getBean(ExecutedJarService.class);
        //jarService.stop();

        frame.setState("Остановка сервиса...");
        stateItem.setLabel("Остановка сервиса...");
        final ExecutedBatService batService = context.getBean(ExecutedBatService.class);
        batService.executeBat(files.get("stop"));
    }

    public static class StartActionListener implements ActionListener {

        private AnnotationConfigApplicationContext context;

        public StartActionListener(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            startApp(context);
        }

    }

    public static class StopActionListener implements ActionListener {

        private AnnotationConfigApplicationContext context;

        public StopActionListener(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopApp(context);
        }

    }

    public static class RestartActionListener implements ActionListener {

        private AnnotationConfigApplicationContext context;

        public RestartActionListener(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopApp(context);
            startApp(context);
        }

    }

    public static class UpdateActionListener implements ActionListener {

        private AnnotationConfigApplicationContext context;

        public UpdateActionListener(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopApp(context);
            update(context);
            startApp(context);
        }

    }

    public static class ExitActionListener implements ActionListener {

        private AnnotationConfigApplicationContext context;

        public ExitActionListener(AnnotationConfigApplicationContext context) {
            this.context = context;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame frame = new JFrame();
            String[] options = new String[2];
            options[0] = new String("Да");
            options[1] = new String("Нет");
            int x = JOptionPane.showOptionDialog(frame.getContentPane(), "Вы уверены, что хотите остановить обновление и работу программы " + appName + "? Работа с сервисом будет недоступна.",
                    "Выход из программы...", 0,
                    JOptionPane.INFORMATION_MESSAGE, null, options, null);
            if (x == 0) {
                if (isAppStarted) {
                    stopApp(context);
                }
                System.exit(0);
            }
        }

    }

}
