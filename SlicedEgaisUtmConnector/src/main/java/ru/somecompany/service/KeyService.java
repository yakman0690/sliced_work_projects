/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service;

import java.util.Properties;

/**
 *
 * @author Alexandra
 */
public interface KeyService {

    public void init(Properties props);

    public String getLogin();

    public String getPassword();

    public String getUrl();
}
