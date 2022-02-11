/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import ru.somecompany.server.service.ParametersService;

/**
 *
 * @author Alexandra
 */
public class ParametersServiceImpl implements ParametersService {

    private Properties props;

    @PostConstruct
    public void init() throws IOException {
        props = new Properties();
        props.load(new FileInputStream("updater.pr"));
    }

    @Override
    public String getUrl() {
        return props.getProperty("url");
    }

    @Override
    public String getResourceName() {
        return props.getProperty("resourceName");
    }

    @Override
    public String getJarName() {
        return props.getProperty("jarName");
    }

    @Override
    public String getReadableName() {

        try {
            return new String(props.getProperty("readableName").getBytes("ISO8859-1"));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

}
