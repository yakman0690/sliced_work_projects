/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service;

import java.util.Properties;

/**
 *
 * @author Alexandra
 */
public interface ExecutedJarService {
    public boolean start(Properties props);
    public boolean stop();
}
