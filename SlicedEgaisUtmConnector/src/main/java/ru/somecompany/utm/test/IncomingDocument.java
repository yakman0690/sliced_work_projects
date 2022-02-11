/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.utm.test;

import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import ru.fsrar.wegais.wb_doc_single_01.Documents;

/**
 *
 * @author Alexandra
 */
public class IncomingDocument {

    @XmlElement
    private String id;
    @XmlElement
    private Map<String, String> attributes;
    @XmlElement
    private Documents entity;

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Documents getEntity() {
        return entity;
    }

    public void setEntity(Documents entity) {
        this.entity = entity;
    }

}
