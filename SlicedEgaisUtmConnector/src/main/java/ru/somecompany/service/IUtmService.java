/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service;

import java.util.List;
import java.util.Map;
import ru.fsrar.wegais.wb_doc_single_01.Documents;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.UtmStates;

/**
 *
 * @author Alexandra
 */
public interface IUtmService {

    public List<DocumentEntity> getIncomingDocumentsList();

    public Map<String, Object> sendRequest(Documents doc, Map<String, Object> params);

    public String getFSRARId();

    public boolean ping();

    public void getUtmEnabled();
    public void updateUtmSettings();

    public UtmStates getUtmState();

    public void setUtmState(UtmStates state);

    public void queryRests();

    public void queryRestsShop();

    public void deleteDocument(String url);

}
