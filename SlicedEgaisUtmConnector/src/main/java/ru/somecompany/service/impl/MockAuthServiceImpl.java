/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.somecompany.mocks.User;
import ru.somecompany.service.AuthService;

/**
 *
 * @author Alexandra
 */
public class MockAuthServiceImpl implements AuthService {

    private final static Logger logger = LoggerFactory.getLogger(MockAuthServiceImpl.class);
    private CookieStore httpCookieStore = new BasicCookieStore();
    private User u;

    @Override
    public void init(String url, String cred) {
        u = new User();
        u.setLogin(cred);
        u.setPassword(cred);
        logger.info("MockAuthService:: Reading user credentials: ".concat(cred).concat(" and connecting to server ").concat(url));
    }

    @Override
    public void authenticate() throws Exception {
        logger.info("MockAuthService:: simulating simple form login to server with the help of HttpEntity. URL: server_url/login ");
        logger.info("MockAuthService:: starting heartbeat to server");
    }

    @Override
    public void close() {
        logger.info("MockAuthService:: shutdown heartbeat to server");
    }

    @Override
    public String getSessionId() {
        logger.info("MockAuthService:: shutdown heartbeat to server");
        return "session_id";
    }

    @Override
    public User getUser() {
        return u;
    }

    @Override
    public String getOU() {
        logger.info("MockAuthService:: get orgunit after auth");
        return "test_org_unit";
    }

    @Override
    public String getUuid() {
        return "some_uuid";
    }

    @Override
    public CookieStore getCookieStore() {
        return httpCookieStore;
    }

    @Override
    public Header getCsrf() {
        logger.info("MockAuthService:: getting csrf from server");
        Header header = new BasicHeader("csrfHeader", "csrfToken");
        return header;
    }

}
