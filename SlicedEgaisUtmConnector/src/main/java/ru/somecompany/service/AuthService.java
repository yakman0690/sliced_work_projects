/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import ru.somecompany.mocks.User;

/**
 *
 * @author Alexandra
 */
public interface AuthService {
    
    public void init(String url, String cred);

    public void authenticate() throws Exception;

    public void close();

    public String getSessionId();

    public User getUser();
    
    public String getOU();
    
    public String getUuid();
    
    public CookieStore getCookieStore();
    
    public Header getCsrf();
}

