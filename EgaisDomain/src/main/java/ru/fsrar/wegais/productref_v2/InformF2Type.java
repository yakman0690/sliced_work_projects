//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.productref_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Справка 2 к ТТН
 * 
 * <p>Java class for InformF2Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InformF2Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InformF2Item" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}InformF2TypeItem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformF2Type", propOrder = {
    "informF2Item"
})
public class InformF2Type {

    @XmlElement(name = "InformF2Item", required = true)
    protected InformF2TypeItem informF2Item;

    /**
     * Gets the value of the informF2Item property.
     * 
     * @return
     *     possible object is
     *     {@link InformF2TypeItem }
     *     
     */
    public InformF2TypeItem getInformF2Item() {
        return informF2Item;
    }

    /**
     * Sets the value of the informF2Item property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformF2TypeItem }
     *     
     */
    public void setInformF2Item(InformF2TypeItem value) {
        this.informF2Item = value;
    }

}
