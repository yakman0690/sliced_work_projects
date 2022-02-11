/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.spring.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import ru.fsrar.wegais.queryparameters.Parameter;
import ru.fsrar.wegais.wb_doc_single_01.DocBody;
import ru.fsrar.wegais.wb_doc_single_01.Documents;
import ru.somecompany.service.EgaisServerService;
import ru.somecompany.service.IUtmService;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.Status;
import ru.somecompany.util.UtmStates;
import ru.somecompany.util.XmlGregorianCalendarConverter;
import ru.somecompany.utm.test.IncomingDocument;

/**
 *
 * @author Alexandra
 *
 * In original configaration we are setting message listener for topic
 * orgunit_egais_out with the help of Atmosphere. As a simplier example we
 * should processing notifications from dummy jms channel open
 */
@Configuration
public class MockServerConfig {

    private final static Logger logger = LoggerFactory.getLogger(MockServerConfig.class);


    @Autowired
    private EgaisServerService egaisServerService;


    @Autowired
    private IUtmService utmService;

    private Map<String, Object> getSendParameters(DocBody body) {
        Map<String, Object> params = new HashMap<>();

        String type = "";
        boolean needUpdateRests = false;
        boolean needUpdateUtmState = false;
        Long waitSeconds = 0l;

        if (body.getActChargeOnV2() != null) {
            type = "ActChargeOn_v2";
            needUpdateRests = true;
        } else if (body.getActChargeOnShopV2() != null) {
            type = "ActChargeOnShop_v2";
            needUpdateRests = true;
        } else if (body.getActWriteOffV2() != null) {
            type = "ActWriteOff_v2";
            needUpdateRests = true;
        } else if (body.getActWriteOffShopV2() != null) {
            //3 minutes after income
            type = "ActWriteOffShop_v2";
            needUpdateRests = true;
            waitSeconds = 3 * 60l;
        } else if (body.getActWriteOffV3() != null) {
            type = "ActWriteOff_v3";
            needUpdateRests = true;
        } else if (body.getWayBillActV2() != null) {
            type = "WayBillAct_v2";
            needUpdateRests = true;
        } else if (body.getWayBillActV3() != null) {
            type = "WayBillAct_v3";
            needUpdateRests = true;
        } else if (body.getWayBillActV4() != null) {
            type = "WayBillAct_v4";
            needUpdateRests = true;
        } else if (body.getWayBillV3() != null) {
            type = "WayBill_v3";
            needUpdateRests = true;
        } else if (body.getWayBillV4() != null) {
            type = "WayBill_v4";
            needUpdateRests = true;
        } else if (body.getQueryRestsV2() != null) {
            type = "QueryRests_v2";
        } else if (body.getQueryRestsShopV2() != null) {
            type = "QueryRestsShop_v2";
        } else if (body.getTransferToShop() != null) {
            type = "TransferToShop";
        } else if (body.getTransferFromShop() != null) {
            type = "TransferFromShop";
        } else if (body.getQueryFormF1() != null) {
            type = "QueryFormF1";
        } else if (body.getQueryFormF2() != null) {
            type = "QueryFormF2";
        } else if (body.getRequestRepealWB() != null) {
            type = "RequestRepealWB";
            needUpdateRests = true;
        } else if (body.getRequestRepealACO() != null) {
            type = "RequestRepealACO";
            needUpdateRests = true;
        } else if (body.getRequestRepealAWO() != null) {
            type = "RequestRepealAWO";
            needUpdateRests = true;
        } else if (body.getQueryResendDoc() != null) {
            type = "QueryResendDoc";
        } else if (body.getQueryAPV2() != null) {
            type = "QueryAP_v2";
        } else if (body.getQueryNATTN() != null) {
            for (Parameter p : body.getQueryNATTN().getParameters().get(0).getParameter()) {
                if (p.getName().equals("utmStateRequest")) {
                    needUpdateUtmState = true;
                    body.getQueryNATTN().getParameters().get(0).getParameter().remove(p);
                    break;
                }
            }
            type = "QueryNATTN";
        } else if (body.getConfirmTicket() != null) {
            type = "WayBillTicket";
        } else if (body.getConfirmTicket() != null) {
            type = "WayBillTicket";
        } else if (body.getQueryHistoryRestShop() != null) {
            type = "QueryHistoryRestShop";
        } else if (body.getQueryRestBCode() != null) {
            type = "QueryRestBCode";
        } else if (body.getQueryFilter() != null) {
            type = "QueryFilter";
        } else if (body.getQuerySPV2() != null) {
            type = "QuerySP_v2";
        } else if (body.getQuerySSPV2() != null) {
            type = "QuerySSP_v2";
        } else if (body.getQueryClientsV2() != null) {
            type = "QueryClients_v2";
        } else if (body.getQueryBarcode() != null) {
            type = "QueryBarcode";
        } else if (body.getTTNHistoryF2Reg() != null) {
            type = "TTNHistoryF2Reg";
        } else if (body.getActFixBarCode() != null) {
            type = "ActFixBarCode";
        } else if (body.getActUnFixBarCode() != null) {
            type = "ActUnFixBarCode";
        } else if (body.getInfoVersionTTN() != null) {
            type = "InfoVersionTTN";
        }
        params.put(ru.somecompany.util.Constants.REQUEST_PARAM_TYPE, type);
        params.put(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_RESTS, needUpdateRests);
        params.put(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_UTMSTATE, needUpdateUtmState);
        params.put(ru.somecompany.util.Constants.REQUEST_PARAM_WAIT_TO_SEND, waitSeconds);
        return params;

    }

    private void processNotification(String data) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(XMLGregorianCalendar.class, new XmlGregorianCalendarConverter.Deserializer())
                .registerTypeAdapter(XMLGregorianCalendar.class, new XmlGregorianCalendarConverter.Serializer())
                .create();
        final IncomingDocument docFromEgaisServer = gson.fromJson(data, IncomingDocument.class);

        final Documents docToSend = docFromEgaisServer.getEntity();

        final Map<String, Object> params = getSendParameters(docToSend.getDocument());
        boolean needUpdateUtmState = false;
        if (params.get(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_UTMSTATE) != null) {
            needUpdateUtmState = (Boolean) params.get(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_UTMSTATE);
        }

        if (needUpdateUtmState) {
            utmService.setUtmState(UtmStates.UTM_UPDATE_STATE);
            UtmStates.setPreviousState(UtmStates.UTM_UPDATE_STATE);
            egaisServerService.setUtmState(utmService.getUtmState());
        }
        Long waitToSend = 0l;
        if (params.get(ru.somecompany.util.Constants.REQUEST_PARAM_WAIT_TO_SEND) != null) {
            waitToSend = (Long) params.get(ru.somecompany.util.Constants.REQUEST_PARAM_WAIT_TO_SEND);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                Map<String, Object> result = utmService.sendRequest(docToSend, params);

                if (result.containsKey(ru.somecompany.util.Constants.RESPONSE_DOCUMENT)) {
                    Documents answerDoc = (Documents) result.get(ru.somecompany.util.Constants.RESPONSE_DOCUMENT);
                    DocumentEntity answerEntity = new DocumentEntity();
                    answerEntity.setDocument(answerDoc);
                    answerEntity.setUrl("");
                    egaisServerService.sendDocument(answerEntity);
                }
                HttpResponse response = null;
                try {
                    response = (HttpResponse) result.get(ru.somecompany.util.Constants.RESPONSE_ANSWER);
                    String requestId = null;
                    if (result.containsKey(ru.somecompany.util.Constants.RESPONSE_REQUEST_ID)) {
                        requestId = (String) result.get(ru.somecompany.util.Constants.RESPONSE_REQUEST_ID);
                    }

                    if (docFromEgaisServer.getId() == null) {
                        return;
                    }

                    if (response != null) {
                        Map<String, Object> responseContent = new HashMap<>();
                        responseContent.put(ru.somecompany.util.Constants.RESPONSE_TTS_DOCID, docFromEgaisServer.getId());

                        if (response.getStatusLine().getStatusCode() == 200) {
                            responseContent.put(ru.somecompany.util.Constants.RESPONSE_STATE, Status.SENT);
                            if (requestId != null) {
                                responseContent.put(ru.somecompany.util.Constants.RESPONSE_REQUEST_ID, requestId);
                            }
                        } else {
                            responseContent.put(ru.somecompany.util.Constants.RESPONSE_STATE, Status.ERROR);
                        }
                        egaisServerService.sendResponse(responseContent);
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                } finally {
                    if (response != null) {
                        EntityUtils.consumeQuietly(response.getEntity());
                    }
                }
            }
        }, waitToSend, TimeUnit.SECONDS);
    }

    private String brokerUrl = "tcp://localhost:11878";
    private String topic = "sometopic";

    @Bean
    public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory
                = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);

        return activeMQConnectionFactory;
    }

    @Bean
    public DefaultMessageListenerContainer orderMessageListenerContainer() {
        SimpleJmsListenerEndpoint endpoint
                = new SimpleJmsListenerEndpoint();
        endpoint.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message msg) {
                try {
                    //Here must be buisness logic for processing incoming message
                    //Look at the login in processNotification()
                    //But here we are preparing some test message, that'll be 
                    Gson gson = new GsonBuilder()
                            .registerTypeAdapter(XMLGregorianCalendar.class, new XmlGregorianCalendarConverter.Deserializer())
                            .registerTypeAdapter(XMLGregorianCalendar.class, new XmlGregorianCalendarConverter.Serializer())
                            .create();
                    final IncomingDocument docFromEgaisServer = gson.fromJson(msg.getBody(String.class), IncomingDocument.class);
                    
                    final Documents docToSend = docFromEgaisServer.getEntity();
                    Map<String, Object> params = new HashMap<>();
                    
                    String type = "";
                    boolean needUpdateRests = false;
                    boolean needUpdateUtmState = false;
                    Long waitSeconds = 0l;
                    params.put(ru.somecompany.util.Constants.REQUEST_PARAM_TYPE, type);
                    params.put(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_RESTS, needUpdateRests);
                    params.put(ru.somecompany.util.Constants.REQUEST_PARAM_UPDATE_UTMSTATE, needUpdateUtmState);
                    params.put(ru.somecompany.util.Constants.REQUEST_PARAM_WAIT_TO_SEND, waitSeconds);
                    
                    Map<String, Object> result = utmService.sendRequest(docToSend, params);
                } catch (JMSException ex) {
                    logger.error(ex.getMessage(),ex);
                }
            }
        });
        endpoint.setDestination(topic);
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());

        return factory.createListenerContainer(endpoint);
    }

}
