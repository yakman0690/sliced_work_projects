/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl;

import java.util.Properties;
import ru.somecompany.service.KeyService;

/**
 *
 * @author Alexandra
 */
public class KeyServiceImpl implements KeyService {
    
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
    
    private Properties props;
    
       
    @Override
    public void init(Properties props) {
        this.props = props;
    }
    
    @Override
    public String getLogin() {
        return props.getProperty("cred");
    }
    
    @Override
    public String getPassword() {
        return props.getProperty("cred");
    }
    
    @Override
    public String getUrl() {
        return props.getProperty("url");
    }
    
    
}
