/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.somecompany.service.IUtmService;
import ru.somecompany.service.impl.UtmServiceImpl;
import ru.somecompany.service.AuthService;
import ru.somecompany.service.EgaisServerService;
import ru.somecompany.service.KeyService;
import ru.somecompany.service.UtmConfigService;
import ru.somecompany.service.impl.EgaisServerServiceImpl;
import ru.somecompany.service.impl.KeyServiceImpl;
import ru.somecompany.service.impl.MockAuthServiceImpl;
import ru.somecompany.service.impl.MockUtmConfigService;

/**
 *
 * @author Alexandra
 */
@Configuration
public class BeanConfig {

    @Bean
    public KeyService keyService() {
        return new KeyServiceImpl();
    }

    @Bean
    public AuthService authService() {
        AuthService as = new MockAuthServiceImpl();
        return as;
    }


    @Bean
    public UtmConfigService utmConfigService() {
        return new MockUtmConfigService();
    }
    
    @Bean
    public IUtmService utmService() {
        return new UtmServiceImpl();
    }
    
     @Bean
    public EgaisServerService egaisServerService() {
        return new EgaisServerServiceImpl();
    }
}