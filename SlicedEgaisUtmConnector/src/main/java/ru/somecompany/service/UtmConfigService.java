/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service;

import java.util.Map;

/**
 *
 * @author Alexandra
 */
public interface UtmConfigService {
    public Map<String, String> refreshConfig() throws Exception;
    Map<String, String> getUtmConfig();
}
