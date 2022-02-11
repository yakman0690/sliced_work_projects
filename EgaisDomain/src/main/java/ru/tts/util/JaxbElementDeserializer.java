/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tts.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 *
 * @author user
 */
public class JaxbElementDeserializer extends StdDeserializer<JAXBElement<String>> {

    public JaxbElementDeserializer() {
        this(null);
    }

    public JaxbElementDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public JAXBElement<String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").textValue();
        String scope = node.get("scope").textValue();
        JsonNode valueNode = node.get("value");
        String value = null;
        if (valueNode != null) {
            value = valueNode.textValue();
        }
        try {
            JAXBElement<String> res = new JAXBElement<>(QName.valueOf(name), String.class, this.getClass().getClassLoader().loadClass(scope), value);
            return res;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

}
