/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fsrar.wegais.wb_doc_single_01.Documents;
import ru.somecompany.util.Constants;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.Status;
import ru.somecompany.util.UtmStates;
import ru.somecompany.service.AuthService;
import ru.somecompany.service.EgaisServerService;
import ru.somecompany.service.KeyService;

/**
 *
 * @author Alexandra
 */
public class EgaisServerServiceImpl implements EgaisServerService {

    private List<DocumentEntity> docsToSend = new LinkedList<>();
    private List<Map<String, String>> responsesToSend = new LinkedList<>();

    private final static Logger logger = LoggerFactory.getLogger(EgaisServerServiceImpl.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private KeyService keyService;

    @Override
    public void setUtmState(UtmStates state) {
        HttpResponse response = null;
        try {
            URI baseUrl = URI.create(keyService.getUrl());
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            HttpClient http = HttpClientBuilder.create().setDefaultCookieStore(authService.getCookieStore()).setSSLSocketFactory(scsf).build();

            HttpPost post = new HttpPost(baseUrl.resolve("./remote/egais/utm/state"));
            post.setHeader(authService.getCsrf());
            post.setEntity(new StringEntity(state.toString()));
            logger.info("Mock egais service: doesn't send real data");
            //response = http.execute(post);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
    }

    @Override
    public void presetSave(Map<String, String> map) {
        try {

            logger.info("Try to update UTM parameters on somecompany Egais server");
            URI baseUrl = URI.create(keyService.getUrl());
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            HttpClient http = HttpClientBuilder.create().setDefaultCookieStore(authService.getCookieStore()).setSSLSocketFactory(scsf).build();

            HttpPost post = new HttpPost(baseUrl.resolve("./remote/egais/preset/save"));
            post.setHeader(authService.getCsrf());
            post.addHeader("Content-Type", "application/json;charset=UTF-8");

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(map);

            post.setEntity(new StringEntity(json, "UTF-8"));
            logger.info("Mock egais service: doesn't send real data");
            //http.execute(post);
        } catch (NoSuchAlgorithmException | KeyManagementException | IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void sendResponse(Map<String, Object> responseContent) {

        logger.info("Try for send NEW responce");
        String id = (String) responseContent.get(Constants.RESPONSE_TTS_DOCID);
        String requestId = null;
        if (responseContent.containsKey(Constants.RESPONSE_REQUEST_ID)) {
            requestId = (String) responseContent.get(Constants.RESPONSE_REQUEST_ID);
        }
        String state = ((Status) responseContent.get(Constants.RESPONSE_STATE)).toString();

        List<Map<String, String>> toRemove = new LinkedList<>();
        for (Map<String, String> respMap : responsesToSend) {

            logger.info("Not empty responces backup: try to send to UTM");
            HttpResponse resp = sendResponseMap(respMap);
            if (resp != null && resp.getStatusLine().getStatusCode() != 200) {
                Map<String, String> mp = new HashMap<>();
                mp.put(Constants.RESPONSE_TTS_DOCID, id);
                mp.put(Constants.RESPONSE_STATE, state);
                if (requestId != null) {
                    mp.put(Constants.RESPONSE_REQUEST_ID, requestId);
                }
                if (!responsesToSend.contains(mp)) {
                    responsesToSend.add(mp);
                }
                writetofile();
                return;
            }
            toRemove.add(respMap);
        }

        responsesToSend.removeAll(toRemove);

        Map<String, String> toSend = new HashMap<>();
        toSend.put(Constants.RESPONSE_TTS_DOCID, id);
        toSend.put(Constants.RESPONSE_STATE, state);
        if (requestId != null) {
            toSend.put(Constants.RESPONSE_REQUEST_ID, requestId);
        }

        HttpResponse response = sendResponseMap(toSend);
        if (response == null || response.getStatusLine().getStatusCode() != 200) {
            Map<String, String> mp = new HashMap<>();
            mp.put(Constants.RESPONSE_TTS_DOCID, id);
            mp.put(Constants.RESPONSE_STATE, state);
            if (requestId != null) {
                mp.put(Constants.RESPONSE_REQUEST_ID, requestId);
            }
            responsesToSend.add(mp);
        } else {
            writetofile();
        }

    }

    private HttpResponse sendResponseMap(Map<String, String> responseMap) {

        String id = responseMap.get(Constants.RESPONSE_TTS_DOCID);
        String state = responseMap.get(Constants.RESPONSE_STATE);
        String requestId = null;
        if (responseMap.containsKey(Constants.RESPONSE_REQUEST_ID)) {
            requestId = responseMap.get(Constants.RESPONSE_REQUEST_ID);
        }

        HttpResponse response = null;
        try {

            logger.info("Try to send response: mark " + id + " as " + state);
            URI baseUrl = URI.create(keyService.getUrl());
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            HttpClient http = HttpClientBuilder.create().setDefaultCookieStore(authService.getCookieStore()).setSSLSocketFactory(scsf).build();

            HttpPost post = new HttpPost(baseUrl.resolve("./remote/egais/document/mark"));
            post.setHeader(authService.getCsrf());
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("id", id));
            nameValuePairs.add(new BasicNameValuePair("state", state));
            if (requestId != null) {
                nameValuePairs.add(new BasicNameValuePair("requestId", requestId));
            }
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            
            logger.info("Mock egais service: doesn't send real data");
            //response = http.execute(post);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
        return response;
    }

    private HttpResponse sendOne(Documents doc, String replyId) {
        HttpResponse response = null;
        try {
            URI baseUrl = URI.create(keyService.getUrl());
            SSLContext sslContext = SSLContexts.custom()
                    .useTLS()
                    .build();
            SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(sslContext, new AllowAllHostnameVerifier());
            HttpClient http = HttpClientBuilder.create().setDefaultCookieStore(authService.getCookieStore()).setSSLSocketFactory(scsf).build();

            String param = "";
            if (replyId != null) {
                param = "?replyId=" + replyId;
            }
            HttpPost post = new HttpPost(baseUrl.resolve("./remote/egais/document/receive" + param));
            post.setHeader(authService.getCsrf());
            post.addHeader("Content-Type", "application/json;charset=UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(doc);
            logger.info("Try to send document: " + json);

            post.setEntity(new StringEntity(json, "UTF-8"));

            logger.info("Mock egais service: doesn't send real data");
            //response = http.execute(post);
        } catch (NoSuchAlgorithmException | KeyManagementException | IOException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            if (response != null) {
                EntityUtils.consumeQuietly(response.getEntity());
            }
        }
        return response;
    }

    List<DocumentEntity> toDelete = new LinkedList<>();

    @Override
    public List<DocumentEntity> getDocsToDelete() {
        logger.info("docs to delete" + toDelete);
        return toDelete;
    }

    @Override
    public boolean sendDocument(DocumentEntity docEntity) {
        if (docEntity.getDocument().getDocument().getWayBillV4() != null) {
            for (ru.fsrar.wegais.ttnsingle_v4.PositionType ptv4 : docEntity.getDocument().getDocument().getWayBillV4().getContent().getPosition()) {
                if (ptv4.getBoxInfo() != null && ptv4.getBoxInfo().getBoxtree() != null) {
                    ptv4.getBoxInfo().getBoxtree().clear();
                }
            }
        }
        logger.info("Request for send new document");

        toDelete.clear();

        for (DocumentEntity docToSend : docsToSend) {
            logger.info("Not empty requests backup: try to send to somecompany Egais Server ");
            HttpResponse resp = sendOne(docToSend.getDocument(), docToSend.getReplyId());
            logger.info("Responce backup " + resp.getStatusLine().getStatusCode());
            if (resp != null && resp.getStatusLine().getStatusCode() == 200) {
                toDelete.add(docToSend);
            }
        }
        docsToSend.removeAll(toDelete);
        HttpResponse response = sendOne(docEntity.getDocument(), docEntity.getReplyId());

        logger.info("Responce " + response.getStatusLine().getStatusCode());
        if (response != null && response.getStatusLine().getStatusCode() == 200) {
            writetofile();
            return true;
        } else {
            if (!docsContains(docEntity)) {
                logger.info("Added to cache " + docEntity);
                docsToSend.add(docEntity);
            }
            writetofile();
            return false;
        }
    }

    private boolean docsContains(DocumentEntity entity) {
        for (DocumentEntity docToSend : docsToSend) {
            String urlToSend = docToSend.getUrl();
            if (urlToSend.equals(entity.getUrl())) {
                return true;
            }
        }
        return false;
    }

    private void writetofile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String docsToSendStr = objectMapper.writeValueAsString(docsToSend);
            String responsesToSendStr = objectMapper.writeValueAsString(responsesToSend);

            logger.info("Prepared for UTM documents BACKUP UPDATE:" + docsToSendStr);
            logger.info("Prepared for UTM responces BACKUP UPDATE:" + responsesToSendStr);
            File doc = new File("docs.txt");
            File r = new File("responses.txt");
            doc.createNewFile();
            r.createNewFile();
            FileUtils.writeStringToFile(doc, docsToSendStr, "UTF-8");
            FileUtils.writeStringToFile(r, responsesToSendStr, "UTF-8");
        } catch (IOException ex) {
            logger.error(ex.getMessage(),ex);
        }
    }

    private void readfromfile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File doc = new File("docs.txt");
            File r = new File("responses.txt");
            doc.createNewFile();
            r.createNewFile();
            String docsToSendStr = FileUtils.readFileToString(doc);
            logger.info("Prepared for UTM documents :" + docsToSendStr);
            String responsesToSendStr = FileUtils.readFileToString(r);
            logger.info("Prepared for EgaisServer responces :" + responsesToSendStr);

            docsToSend = objectMapper.readValue(docsToSendStr, new TypeReference<List<DocumentEntity>>() {
            });
            responsesToSend = objectMapper.readValue(responsesToSendStr, new TypeReference<List<Map<String, String>>>() {
            });
            if (docsToSend == null) {
                docsToSend = new LinkedList<>();
            }

            if (responsesToSend == null) {
                responsesToSend = new LinkedList<>();
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    @Override
    public void init() {
        logger.info("somecompany Egais Server Service starts: loading requests from backup");
        readfromfile();
    }
}
