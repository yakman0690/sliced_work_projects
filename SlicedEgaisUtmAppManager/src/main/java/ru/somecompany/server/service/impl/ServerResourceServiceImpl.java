/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.server.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.somecompany.server.service.ServerResourceService;

/**
 *
 * @author Alexandra
 * 
 * Checks and gets file from remote server
 */


public class ServerResourceServiceImpl implements ServerResourceService {

    private final static Logger logger = LoggerFactory.getLogger(ServerResourceServiceImpl.class);
    private HttpClient http;
    private String url;    
    private String resourceName;

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private CookieStore httpCookieStore;

    @Override
    public String getHash() {
        String hash = null;
        HttpResponse response = null;
        HttpEntity hashEntity = null;
        try {

            httpCookieStore = new BasicCookieStore();
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            http = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).setSSLSocketFactory(scsf).build();

            URI baseUrl = URI.create(url);
            URI uri = baseUrl.resolve("./public/egais/resource/hash?name=" + resourceName);
            HttpGet httpget = new HttpGet(uri);
            response = http.execute(httpget);
            hashEntity = response.getEntity();
            Gson gson = new Gson();
            Map<String, String> hashMap = gson.fromJson(new InputStreamReader(hashEntity.getContent()), new TypeToken<Map<String, String>>() {
            }.getType());
            hash = hashMap.get("hash");
        } catch (NoSuchAlgorithmException | KeyManagementException | IOException | UnsupportedOperationException | JsonIOException | JsonSyntaxException ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (hashEntity != null) {
                EntityUtils.consumeQuietly(hashEntity);
            }
        }
        return hash;

    }

    @Override
    public void downloadFile() {
        HttpResponse response = null;
        HttpEntity responceEntity = null;
        try {
            httpCookieStore = new BasicCookieStore();
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            http = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).setSSLSocketFactory(scsf).build();

            URI baseUrl = URI.create(url);
            URI uri = baseUrl.resolve("./public/egais/resource/get?name=" + resourceName);
            HttpGet httpget = new HttpGet(uri);
            response = http.execute(httpget);
            responceEntity = response.getEntity();

            if (responceEntity != null) {
                InputStream stream = responceEntity.getContent();
                byte buf[] = new byte[1024 * 1024];
                int numBytesRead;

                BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(resourceName));

                do {
                    numBytesRead = stream.read(buf);
                    if (numBytesRead > 0) {
                        fos.write(buf, 0, numBytesRead);

                    }
                } while (numBytesRead > 0);
                fos.flush();
                fos.close();
                stream.close();
                buf = null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (responceEntity != null) {
                EntityUtils.consumeQuietly(responceEntity);
            }
        }
    }

}
