//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.repimportedproduct;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.fsrar.wegais.repimportedproduct package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.fsrar.wegais.repimportedproduct
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RepImportedType }
     * 
     */
    public RepImportedType createRepImportedType() {
        return new RepImportedType();
    }

    /**
     * Create an instance of {@link PositionType }
     * 
     */
    public PositionType createPositionType() {
        return new PositionType();
    }

    /**
     * Create an instance of {@link RepImportedType.Header }
     * 
     */
    public RepImportedType.Header createRepImportedTypeHeader() {
        return new RepImportedType.Header();
    }

    /**
     * Create an instance of {@link RepImportedType.Content }
     * 
     */
    public RepImportedType.Content createRepImportedTypeContent() {
        return new RepImportedType.Content();
    }

}
