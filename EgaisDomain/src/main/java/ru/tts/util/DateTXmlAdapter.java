/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tts.util;

/**
 *
 * @author Alexandra
 */
public class DateTXmlAdapter extends AbstractDateXmlAdapter{

    public DateTXmlAdapter() {
        super("yyyy-MM-dd'T'HH:mm:ss.SSSz");
    }
    
}
