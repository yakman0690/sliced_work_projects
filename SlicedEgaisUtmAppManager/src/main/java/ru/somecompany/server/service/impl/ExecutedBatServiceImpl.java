/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service.impl;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.somecompany.server.service.ExecutedBatService;

/**
 *
 * @author Alexandra
 */
public class ExecutedBatServiceImpl implements ExecutedBatService {

    private static final Logger logger = LoggerFactory.getLogger(ExecutedBatServiceImpl.class);

    @Override
    public boolean executeBat(File file) {
        try {
            Runtime.
                    getRuntime().
                    exec(file.getAbsolutePath());
            return true;
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
            return false;
        }
    }

  

}
