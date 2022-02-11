/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.somecompany.server.service.ExecutedJarService;

/**
 *
 * @author Alexandra
 */
public class ExecutedJarServiceImpl implements ExecutedJarService {

    private static final Logger logger = LoggerFactory.getLogger(ExecutedJarServiceImpl.class);
    private String folderName;
    private String appName;

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    private String[] getArgs(Properties props) {
        String cred = props.getProperty("cred");
        String url = props.getProperty("url");
        String[] args = new String[]{"-u", url, "-l", cred};
        return args;
    }

    private boolean exec(String[] command) {
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.directory(new File(folderName));
            Process ps = builder.start();
            logger.info("try to exec: " + folderName + Arrays.toString(command));
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return false;
        }
    }

    @Override
    public boolean start(Properties props) {
        String[] args = getArgs(props);
        String[] command = ArrayUtils.addAll(new String[]{"javaw", "-Dfile.encoding=UTF-8", "-jar", appName, "start"}, args);
        logger.info("command is: " + command.toString());
        boolean res = exec(command);
        logger.info("exec res = " + res);
        return res;
        /*try {
            Runtime.
                    getRuntime().
                    exec("cmd /c start C:\\somecompany\\AppManager\\app\\bats\\utm_start.bat");
            return true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ExecutedJarServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;*/
    }

    @Override
    public boolean stop() {
        String[] command = new String[]{"javaw", "-Dfile.encoding=UTF-8", "-jar", appName, "stop"};
        logger.info("command is: " + command.toString());
        boolean res = exec(command);
        logger.info("exec res = " + res);
        return res;
    }

}
