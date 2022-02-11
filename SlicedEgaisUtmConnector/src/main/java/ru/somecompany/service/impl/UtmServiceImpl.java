/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import ru.fsrar.wegais.queryparameters.QueryParameters;
import ru.fsrar.wegais.wb_doc_single_01.DocBody;
import ru.fsrar.wegais.wb_doc_single_01.Documents;
import ru.fsrar.wegais.wb_doc_single_01.SenderInfo;
import ru.somecompany.service.IUtmService;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.somecompany.util.Constants;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.UtmStates;
import ru.somecompany.service.UtmConfigService;

/**
 *
 * @author Alexandra
 */
public class UtmServiceImpl implements IUtmService {

    @Autowired
    private UtmConfigService utmConfigService;

    RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).build();
    final HttpClient http = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UtmServiceImpl.class);

    private UtmStates utmState = UtmStates.UTM_READY;

    @Override
    public UtmStates getUtmState() {
        return utmState;
    }

    @Override
    public void setUtmState(UtmStates state) {
        utmState = state;
    }

    @Override
    public void getUtmEnabled() {
        boolean ping = ping();
        if (!ping) {
            utmState = UtmStates.UTM_STOPPED;
        } else if (utmState == UtmStates.UTM_STOPPED) {
            //только что включили
            utmState = UtmStates.UTM_READY;
        }
        //другие проблемы
    }

    @Override
    public boolean ping() {
        logger.info("ping");
        HttpEntity outEntity = null;
        try {
            URI baseUrl = URI.create(utmConfigService.getUtmConfig().get("utm.url"));
            HttpGet outGet = new HttpGet(baseUrl.resolve("/diagnosis"));
            HttpResponse outResponse = http.execute(outGet);
            outEntity = outResponse.getEntity();
            return true;
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
            return false;
        } finally {
            EntityUtils.consumeQuietly(outEntity);
        }
    }

    @Override
    public void updateUtmSettings() {

        HttpEntity updateEntity = null;
        try {
            URI baseUrl = URI.create(utmConfigService.getUtmConfig().get("utm.url"));
            HttpGet outGet = new HttpGet(baseUrl.resolve("/xhr/filter/reset"));
            HttpResponse outResponse = http.execute(outGet);
            updateEntity = outResponse.getEntity();
            int statusCode = outResponse.getStatusLine().getStatusCode();
            logger.info("Reset settings result " + statusCode);
        } catch (Exception ex) {
            logger.info("Reset settings error");
            logger.error(ex.getMessage(), ex);
        } finally {
            if (updateEntity != null) {
                EntityUtils.consumeQuietly(updateEntity);
            }
        }

    }

    @Override
    public String getFSRARId() {
        logger.info("try to get fsrarid");
        HttpEntity outEntity = null;
        try {
            URI baseUrl = URI.create(utmConfigService.getUtmConfig().get("utm.url"));
            HttpGet outGet = new HttpGet(baseUrl.resolve("/diagnosis"));
            HttpResponse outResponse = http.execute(outGet);
            outEntity = outResponse.getEntity();
            String xmlAnswer = EntityUtils.toString(outEntity);
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xmlAnswer)));
            Element root = document.getDocumentElement();
            NodeList lst = root.getElementsByTagName("CN");
            for (int i = 0; i < lst.getLength(); i++) {
                String textContent = lst.item(i).getTextContent();
                logger.info("got fsrarid " + textContent);
                return textContent;
            }
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            EntityUtils.consumeQuietly(outEntity);
        }
        return null;
    }

    private List<Map<String, String>> parseXmlGetUrls(String xml) {
        List<Map<String, String>> urlList = new LinkedList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));
            Element root = document.getDocumentElement();
            NodeList lst = root.getElementsByTagName("url");
            for (int i = 0; i < lst.getLength(); i++) {
                Element e = (Element) lst.item(i);
                String replyId = e.getAttribute("replyId");
                String textContent = lst.item(i).getTextContent();
                Map<String, String> mapItem = new HashMap<>();
                if (replyId != null) {
                    mapItem.put("replyId", replyId);
                }
                mapItem.put("url", textContent);
                urlList.add(mapItem);
            }
        } catch (IOException | SAXException | ParserConfigurationException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return urlList;
    }

    private Documents getIncomingDocument(String url) {

        logger.info("Try to get doc: " + url);
        Documents doc = null;
        HttpEntity docEntity = null;
        try {
            URI docUrl = URI.create(url);
            HttpGet outGet = new HttpGet(docUrl);
            HttpResponse outResponse = http.execute(outGet);
            docEntity = outResponse.getEntity();

            JAXBContext jaxbContext = JAXBContext.newInstance(Documents.class
            );
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            doc = (Documents) jaxbUnmarshaller.unmarshal(docEntity.getContent());

            logger.info("Got");

        } catch (IOException | JAXBException | IllegalStateException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            EntityUtils.consumeQuietly(docEntity);
        }
        return doc;
    }

    @Override
    public List<DocumentEntity> getIncomingDocumentsList() {

        logger.info("Check for incoming documents");
        List<DocumentEntity> documentsList = new LinkedList<>();
        HttpEntity outEntity = null;
        try {
            URI baseUrl = URI.create(utmConfigService.getUtmConfig().get("utm.url"));
            HttpGet outGet = new HttpGet(baseUrl.resolve("/opt/out"));
            HttpResponse outResponse = http.execute(outGet);
            outEntity = outResponse.getEntity();
            String xmlAnswer = EntityUtils.toString(outEntity);
            List<Map<String, String>> urlList = parseXmlGetUrls(xmlAnswer);

            logger.info("Incoming: " + urlList);
            for (Map<String, String> item : urlList) {
                String url = item.get("url");
                String replyId = item.get("replyId");
                Documents doc = getIncomingDocument(url);
                DocumentEntity entity = new DocumentEntity();
                entity.setDocument(doc);
                entity.setUrl(url);
                entity.setReplyId(replyId);
                documentsList.add(entity);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            EntityUtils.consumeQuietly(outEntity);
        }
        return documentsList;
    }

    @Override
    public void deleteDocument(String url) {
        logger.info("Try to delete doc: " + url);
        HttpResponse outResponse = null;
        try {
            URI docUrl = URI.create(url);
            HttpDelete outDelete = new HttpDelete(docUrl);
            outResponse = http.execute(outDelete);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            EntityUtils.consumeQuietly(outResponse.getEntity());
        }
    }

    private String getRequestUniqueID(InputStream in) {
        String result = null;
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document docX = builder.parse(new InputSource(in));

            NodeList nl = docX.getElementsByTagName("url");
            if (nl != null && nl.getLength() > 0) {
                Node n = nl.item(0);
                result = n.getTextContent();
            }

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return result;
    }

    private Map<String, Object> sendDocument(Documents doc, String type) {
        Map<String, Object> responseMap = new HashMap<>();

        logger.info("Try to send documents " + type);
        HttpResponse response = null;

        HttpEntity responseEntity = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Documents.class
            );
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(doc, sw);

            String xml = sw.toString();

            logger.info("Doc " + xml);
            File temp = File.createTempFile(type + "_", ".xml");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            bw.write(xml);
            bw.close();

            TransformerFactory tf = TransformerFactory.newInstance();
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("ru/somecompany/util/Stylesheet.xml");
            Transformer transformer = tf.newTransformer(new StreamSource(stream));

            File temp2 = File.createTempFile(type, ".xml");
            transformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(temp2));

            URI baseUrl = URI.create(utmConfigService.getUtmConfig().get("utm.url"));
            URI postToUrl = baseUrl.resolve("/opt/in/" + type);
            if (doc.getDocument().getQueryFilter() != null) {
                //postToUrl = baseUrl.resolve("/home/opt/in/" + type);
            }
            HttpPost outPost = new HttpPost(postToUrl);
            //String postToUrl = outPost.getURI().toString();
            //outPost.setHeader("Content-Type","multipart/form-data");
            // FileBody body;
            // body = new FileBody(temp2, org.apache.http.entity.ContentType.MULTIPART_FORM_DATA);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("xml_file", temp2);
            /*  HttpEntity entity = MultipartEntityBuilder.create()
                    .addPart("xml_file", body)
                    .build();*/
            HttpEntity entity = builder.build();
            outPost.setEntity(entity);

            //logger.info("Test 1");
            response = http.execute(outPost);

            logger.info("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 500) {
                utmState = UtmStates.UTM_UNKNOWN_PROBLEM;
            } else {
                utmState = UtmStates.UTM_READY;
            }

            //logger.info("Test 2");
            responseEntity = response.getEntity();
            InputStream in = responseEntity.getContent();
            //logger.info("Test 3");

            if (doc.getDocument().getQueryFilter() == null) {
                String requestUniqueId = getRequestUniqueID(in);
                if (requestUniqueId != null) {
                    responseMap.put(Constants.RESPONSE_REQUEST_ID, requestUniqueId);
                }
            }

            if (doc.getDocument().getQueryFilter() != null) {

                logger.info("Query filter on: " + postToUrl.toString());
                JAXBContext jaxbContext2 = JAXBContext.newInstance(Documents.class
                );
                Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();

                String text = new BufferedReader(
                        new InputStreamReader(in, StandardCharsets.UTF_8)).lines()
                        .collect(Collectors.joining("\n"));

                text = text.replace("xmlns=\"http://fsrar.ru/WEGAIS/ReplyFilter\"", "xmlns=\"http://fsrar.ru/WEGAIS/QueryFilter\"");

                StringReader reader = new StringReader(text);
                Documents d1 = (Documents) unmarshaller.unmarshal(reader);
                // Documents d1 = (Documents) unmarshaller.unmarshal(in);
                d1.getDocument();
                responseMap.put(Constants.RESPONSE_DOCUMENT, d1);
                logger.info("Doc response: " + d1.getDocument().toString());
            }
            // logger.info("Test 4");
            //String responseAsString = EntityUtils.toString(in);
            //logger.info("Doc response: " + response + " " + in);

        } catch (JAXBException | IOException | TransformerException ex) {
            logger.error(ex.getMessage(), ex);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        } finally {
            EntityUtils.consumeQuietly(responseEntity);

        }
        responseMap.put(Constants.RESPONSE_ANSWER, response);
        return responseMap;
    }

    @Override
    public void queryRests() {
        logger.info("try to query rests v2");
        Documents queryRests = prepareQueryRests();
        String type = "QueryRests_v2";
        sendDocument(queryRests, type);
    }

    private Documents prepareQueryRests() {

        Documents docs = new Documents();
        SenderInfo senderInfo = new SenderInfo();
        senderInfo.setFSRARID(getFSRARId());
        docs.setOwner(senderInfo);
        DocBody doc = new DocBody();
        doc.setQueryRestsV2(new QueryParameters());
        docs.setDocument(doc);
        return docs;

    }

    @Override
    public void queryRestsShop() {

        logger.info("try to query rests v2");
        Documents queryRestsShop = prepareQueryRestsShop();
        String type = "QueryRestsShop_v2";
        sendDocument(queryRestsShop, type);
    }

    private Documents prepareQueryRestsShop() {

        Documents docs = new Documents();
        SenderInfo senderInfo = new SenderInfo();
        senderInfo.setFSRARID(getFSRARId());
        docs.setOwner(senderInfo);
        DocBody doc = new DocBody();
        doc.setQueryRestsShopV2(new QueryParameters());
        docs.setDocument(doc);
        return docs;

    }

    @Override
    public Map<String, Object> sendRequest(final Documents doc, Map<String, Object> params) {

        boolean needUpdateRests = false;

        if (params.get(Constants.REQUEST_PARAM_TYPE) == null) {
            throw new IllegalArgumentException("No doc type");
        }
        final String docType = (String) params.get(Constants.REQUEST_PARAM_TYPE);

        if (params.get(Constants.REQUEST_PARAM_UPDATE_RESTS) != null) {
            needUpdateRests = (Boolean) params.get(Constants.REQUEST_PARAM_UPDATE_RESTS);
        }

        //logger.info("before send");
        Map<String, Object> sendResult = sendDocument(doc, docType);
        //logger.info("after send");

        if ("WayBillAct_v3".equals(docType)) {
            logger.info("Successfully sent way bill act: need to update UTM settings");
            updateUtmSettings();
        }
        if (needUpdateRests) {
            HttpResponse response = (HttpResponse) sendResult.get(Constants.RESPONSE_ANSWER);
            if (response.getStatusLine().getStatusCode() == 200) {
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.schedule(new Runnable() {
                    @Override
                    public void run() {
                        logger.info("Successfully sent: " + docType + ", try to queryRests after 5 minutes ");
                        queryRests();
                        queryRestsShop();
                    }

                }, 5, TimeUnit.MINUTES);
            }
        }

        return sendResult;

    }

}
