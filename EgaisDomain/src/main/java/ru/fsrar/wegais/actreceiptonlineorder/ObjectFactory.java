//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.actreceiptonlineorder;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.fsrar.wegais.actreceiptonlineorder package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.fsrar.wegais.actreceiptonlineorder
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActReceiptOnlineOrderType }
     * 
     */
    public ActReceiptOnlineOrderType createActReceiptOnlineOrderType() {
        return new ActReceiptOnlineOrderType();
    }

    /**
     * Create an instance of {@link ActReceiptOnlineOrderPositionType }
     * 
     */
    public ActReceiptOnlineOrderPositionType createActReceiptOnlineOrderPositionType() {
        return new ActReceiptOnlineOrderPositionType();
    }

    /**
     * Create an instance of {@link ActReceiptOnlineOrderType.Header }
     * 
     */
    public ActReceiptOnlineOrderType.Header createActReceiptOnlineOrderTypeHeader() {
        return new ActReceiptOnlineOrderType.Header();
    }

    /**
     * Create an instance of {@link ActReceiptOnlineOrderType.Content }
     * 
     */
    public ActReceiptOnlineOrderType.Content createActReceiptOnlineOrderTypeContent() {
        return new ActReceiptOnlineOrderType.Content();
    }

}
