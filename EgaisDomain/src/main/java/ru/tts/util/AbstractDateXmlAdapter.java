/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tts.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Alexandra
 */
public abstract class AbstractDateXmlAdapter extends XmlAdapter<String, XMLGregorianCalendar>{
    
    
    AbstractDateXmlAdapter(String format){
        dateFormat = new SimpleDateFormat(format);
    }
    
    private final SimpleDateFormat dateFormat;
    
    @Override
    public String marshal(XMLGregorianCalendar v) throws Exception {
        Calendar calendar = v.toGregorianCalendar();
        dateFormat.setTimeZone(calendar.getTimeZone());
        return dateFormat.format(calendar.getTime());
    }
    
    @Override
    public XMLGregorianCalendar unmarshal(String v) throws Exception {
        XMLGregorianCalendar xmlCalender = null;
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(dateFormat.parse(v));
        xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        return xmlCalender;
    }
    
}
