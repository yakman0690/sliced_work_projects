//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.queryformab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Запрос на информацию по Форме А для Товарно-Транспортной Накладной
 * 
 * <p>Java class for QueryFormAB complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryFormAB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FormRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryFormAB", propOrder = {
    "formRegId"
})
public class QueryFormAB {

    @XmlElement(name = "FormRegId", required = true)
    protected String formRegId;

    /**
     * Gets the value of the formRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormRegId() {
        return formRegId;
    }

    /**
     * Sets the value of the formRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormRegId(String value) {
        this.formRegId = value;
    }

}
