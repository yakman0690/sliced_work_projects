/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.somecompany.server.service.ExecutedBatService;
import ru.somecompany.server.service.ExecutedJarService;
import ru.somecompany.server.service.FSService;
import ru.somecompany.server.service.ParametersService;
import ru.somecompany.server.service.ServerResourceService;
import ru.somecompany.server.service.impl.ExecutedBatServiceImpl;
import ru.somecompany.server.service.impl.ExecutedJarServiceImpl;
import ru.somecompany.server.service.impl.FSServiceImpl;
import ru.somecompany.server.service.impl.ParametersServiceImpl;
import ru.somecompany.server.service.impl.ServerResourceServiceImpl;

/**
 *
 * @author Alexandra
 */
@Configuration
public class AppConfig {

    @Bean
    public ParametersService parametersService() {
        ParametersServiceImpl parametersServiceImpl = new ParametersServiceImpl();
        return parametersServiceImpl;
    }

    @Bean
    public ExecutedJarService executedJarService() {
        ExecutedJarServiceImpl service = new ExecutedJarServiceImpl();
        service.setFolderName(parametersService().getResourceName().replace(".zip", ""));
        service.setAppName(parametersService().getJarName());
        return service;
    }

    @Bean
    public ExecutedBatService executedBatService() {
        return new ExecutedBatServiceImpl();
    }

    @Bean
    public FSService fSService() {
        FSServiceImpl fSServiceImpl = new FSServiceImpl();
        fSServiceImpl.setFolderName(parametersService().getResourceName().replace(".zip", ""));
        return fSServiceImpl;
    }

    @Bean
    public ServerResourceService serverResourceService() {
        ServerResourceServiceImpl serverResourceServiceImpl = new ServerResourceServiceImpl();
        serverResourceServiceImpl.setUrl(parametersService().getUrl());
        serverResourceServiceImpl.setResourceName(parametersService().getResourceName());
        return serverResourceServiceImpl;

    }
}
