/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.somecompany.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Alexandra
 */
public class XmlGregorianCalendarConverter {
    public static class Serializer implements JsonSerializer {

        public Serializer() {
            super();
        }
        @Override
        public JsonElement serialize(Object t, Type type,
                JsonSerializationContext jsonSerializationContext) {
            XMLGregorianCalendar xgcal = (XMLGregorianCalendar) t;
            //return new JsonPrimitive(xgcal.toXMLFormat());
            return new JsonPrimitive(xgcal.toGregorianCalendar().getTime().getTime());
        }

    }
    public static class Deserializer implements JsonDeserializer {

        @Override
        public Object deserialize(JsonElement jsonElement, Type type,
                JsonDeserializationContext jsonDeserializationContext) {
            try {
                JsonObject obj  = jsonElement.getAsJsonObject();
                XMLGregorianCalendar xmlGregCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(obj.get("year").getAsInt(), 
                                                                     obj.get("month").getAsInt(), 
                                                                     obj.get("day").getAsInt(), 
                                                                     obj.get("hour").getAsInt(), 
                                                                     obj.get("minute").getAsInt(),obj.get("second").getAsInt(),
                                                                     0, obj.get("timezone").getAsInt());
                return xmlGregCalendar;
            } catch (Exception e) {
                return null;
            }
        }

    }
}