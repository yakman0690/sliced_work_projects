/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.startup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.apache.log4j.PropertyConfigurator;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.somecompany.desktop.utils.Constants;
import ru.somecompany.mocks.User;
import ru.somecompany.spring.config.BeanConfig;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.UtmStates;
import ru.somecompany.service.IUtmService;
import ru.somecompany.service.AuthService;
import ru.somecompany.service.EgaisServerService;
import ru.somecompany.service.KeyService;
import ru.somecompany.service.UtmConfigService;
import ru.somecompany.spring.config.MockServerConfig;

/**
 *
 * @author user
 */
public class Startup {

    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private final static ScheduledExecutorService schedulerChecker = Executors.newScheduledThreadPool(2);
    private static AnnotationConfigApplicationContext serverContext;
    private static AnnotationConfigApplicationContext appContext;
    private static final Logger logger = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {

        appContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        PropertyConfigurator.configure(Startup.class.getClassLoader().getResourceAsStream("ru/somecompany/config/log4j.properties"));
        String command = args.length > 0 ? args[0] : "start";
        logger.info("command is {}", command);
        try {
            switch (command) {
                case "help": {
                    help();
                    break;
                }
                case "?": {
                    help();
                    break;
                }
                case "start": {
                    init(args);
                    startup();
                    break;
                }
                case "stop": {
                    stop();
                    break;
                }
                default: {
                    logger.info("Для помощи в работе с программой введите -help");
                }
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private static void help() {
        logger.info("ТТС.УТМ-коннектор. \n"
                + "Использование: java -jar euc.jar command [options] \n"
                + "Допустимые команды: \n"
                + "     help, ? - справка \n "
                + "     start - старт службы\n "
                + "     stop - остановка службы \n "
                + "     restart - перезапуск службы  \n "
                + "Опции: \n "
                + "     -f name файл конфигурации \n "
                + "     -u url \n "
                + "     -l login \n ");
    }

    private static void init(String[] args) {
        String url = null;
        String cred = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                if (i + 1 < args.length) {
                    initByFile(args[i + 1]);
                    return;
                }
            }
            if (args[i].equals("-u")) {
                if (i + 1 < args.length) {
                    url = args[i + 1];
                }
            }
            if (args[i].equals("-l")) {
                if (i + 1 < args.length) {
                    cred = args[i + 1];
                }
            }

        }

        if (url != null && cred != null) {
            initByData(url, cred);
        }

        if (url == null && cred == null) {
            initByFile("conf.pr");
        }
    }

    private static void initByFile(String filename) {

        File f = new File(filename);
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Конфигурационный файл для настройки подключения УТМ-ЕГАИС не загружен.",
                    "Ошибка!",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
            return;
        }

        try {
            char[] b = new char[]{
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

            KeyService ks = appContext.getBean(KeyService.class);
            AuthService as = appContext.getBean(AuthService.class);
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPasswordCharArray(b);
            encryptor.initialize();
            Properties props = new EncryptableProperties(encryptor);
            props.load(new FileInputStream("conf.pr"));
            ks.init(props);
            as.init(ks.getUrl(), ks.getLogin());
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    private static void initByData(String url, String cred) {
        Properties props = new Properties();
        KeyService ks = appContext.getBean(KeyService.class);
        AuthService as = appContext.getBean(AuthService.class);
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        map.put("cred", cred);
        props.putAll(map);
        ks.init(props);
        as.init(ks.getUrl(), ks.getLogin());
    }

    private static void stop() throws IOException {

        logger.info("Try to stop app");
        Socket socket = new Socket(InetAddress.getLoopbackAddress(), Constants.EUC_PORT);
        socket.getInputStream();
    }

    private static void startup() throws IOException {

        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.gc();
            }
        }, 10, 10, TimeUnit.MINUTES);

        //check if it is running
        scheduler.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(Constants.EUC_PORT, 0, InetAddress.getLoopbackAddress());
                    serverSocket.accept();
                    System.exit(0);
                } catch (IOException ex) {
                    logger.error(ex.getMessage(), ex);
                    System.exit(0);
                }
            }
        });

        // putToTray();
        User u = null;
        //final AnnotationConfigApplicationContext authContext = new AnnotationConfigApplicationContext(AuthConfig.class);
        logger.info("Egais UTM connector startup: try to connect");
        do {
            try {
                AuthService as = appContext.getBean(AuthService.class);
                logger.info("calling auth from startup");
                as.authenticate();
                u = as.getUser();
                if (u == null) {
                    Thread.sleep(5000);
                }

                EgaisServerService ess = appContext.getBean(EgaisServerService.class);
                ess.init();

                UtmConfigService utmConfigService = appContext.getBean(UtmConfigService.class);
                Map<String, String> config = utmConfigService.refreshConfig();
                IUtmService utmService = appContext.getBean(IUtmService.class);

                String fsraridUtm = utmService.getFSRARId();
                if (fsraridUtm != null && (config.get("utm.fsrarid") == null
                        || !config.get("utm.fsrarid").equals(fsraridUtm))) {
                    Map<String, String> map = new HashMap<>();
                    map.put("utm.fsrarid", fsraridUtm);
                    ess.presetSave(map);
                }

            } catch (Exception ex) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex1) {
                }
                logger.error(ex.getMessage(), ex);
            }
        } while (u == null);

        serverContext = new AnnotationConfigApplicationContext();
        serverContext.setParent(appContext);
        serverContext.register(MockServerConfig.class);
        serverContext.refresh();

        ScheduledExecutorService tmpExecutorService = Executors.newScheduledThreadPool(2);

        UtmStates.setPreviousState(null);
        tmpExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    IUtmService utmService = appContext.getBean(IUtmService.class);
                    EgaisServerService ees = appContext.getBean(EgaisServerService.class);
                    UtmStates previousState = UtmStates.getPreviousState();
                    if (previousState == null || !previousState.equals(utmService.getUtmState())) {
                        previousState = utmService.getUtmState();
                        UtmStates.setPreviousState(previousState);
                        ees.setUtmState(utmService.getUtmState());
                    }
                } catch (Exception ex) {

                }
            }

        }, 0, 10, TimeUnit.SECONDS);

        ScheduledExecutorService utmPingService = Executors.newScheduledThreadPool(2);
        utmPingService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    //logger.info("Update UTM state");
                    IUtmService utmService = appContext.getBean(IUtmService.class);
                    utmService.getUtmEnabled();
                } catch (Exception ex) {
                }
            }

        }, 0, 20, TimeUnit.SECONDS);
        
        ScheduledExecutorService updateSettingsService = Executors.newScheduledThreadPool(2);
        updateSettingsService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    IUtmService utmService = appContext.getBean(IUtmService.class);
                    utmService.updateUtmSettings();
                } catch (Exception ex) {
                }
            }

        }, 0, 30, TimeUnit.MINUTES);

        schedulerChecker.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                try {
                    logger.info("Request UTM every minute");
                    IUtmService utmService = appContext.getBean(IUtmService.class);
                    EgaisServerService ees = appContext.getBean(EgaisServerService.class);

                    List<DocumentEntity> lst = utmService.getIncomingDocumentsList();
                    for (DocumentEntity d : lst) {
                        if (d.getDocument().getDocument().getConfirmTicket() != null) {
                            utmService.queryRests();
                            utmService.queryRestsShop();
                        }
                        if (ees.sendDocument(d)) {
                            utmService.deleteDocument(d.getUrl());
                        }
                        for (DocumentEntity entityToDelete : ees.getDocsToDelete()) {
                            utmService.deleteDocument(entityToDelete.getUrl());
                        }
                    }

                } catch (Exception ex) {
                    logger.info(ex.getMessage(), ex);
                }
            }
        }, 0, 60, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                serverContext.destroy();
                scheduler.shutdown();
                schedulerChecker.shutdown();
            }
        });
    }

   
}
