//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.clientref_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Транспортное средство
 * 
 * <p>Java class for TRType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TRType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ClientRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="address" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgAddressTypeTR"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRType", propOrder = {

})
public class TRType {

    @XmlElement(name = "ClientRegId", required = true)
    protected String clientRegId;
    @XmlElement(required = true)
    protected OrgAddressTypeTR address;

    /**
     * Gets the value of the clientRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientRegId() {
        return clientRegId;
    }

    /**
     * Sets the value of the clientRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientRegId(String value) {
        this.clientRegId = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link OrgAddressTypeTR }
     *     
     */
    public OrgAddressTypeTR getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgAddressTypeTR }
     *     
     */
    public void setAddress(OrgAddressTypeTR value) {
        this.address = value;
    }

}
