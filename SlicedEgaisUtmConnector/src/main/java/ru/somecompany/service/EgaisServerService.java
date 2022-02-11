/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.service;

import java.util.List;
import java.util.Map;
import ru.somecompany.util.DocumentEntity;
import ru.somecompany.util.UtmStates;

/**
 *
 * @author Alexandra
 */
public interface EgaisServerService {
    
    public void init();

    public void sendResponse(Map<String, Object> responseContent);
    
    public void setUtmState(UtmStates state);

    public boolean sendDocument(DocumentEntity doc);

    public void presetSave(Map<String, String> map);
    
    List<DocumentEntity> getDocsToDelete();
}
