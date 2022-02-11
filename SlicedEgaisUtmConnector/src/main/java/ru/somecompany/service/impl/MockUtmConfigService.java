/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl;

import java.util.HashMap;
import java.util.Map;
import ru.somecompany.service.UtmConfigService;

/**
 *
 * @author Alexandra
 * 
 */
public class MockUtmConfigService implements UtmConfigService{
    private Map<String, String> conf;

    public MockUtmConfigService() {
        conf = new HashMap<>();
        conf.put("utm.fsrarid", "732467623");
        conf.put("utm.url", "http://localhost:8080/");
    }
    
    

    @Override
    public Map<String, String> refreshConfig() throws Exception {
        return conf;
    }

    @Override
    public Map<String, String> getUtmConfig() {
        return conf;
    }
    
}
