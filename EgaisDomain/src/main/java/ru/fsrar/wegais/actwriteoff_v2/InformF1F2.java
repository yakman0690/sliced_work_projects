//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.actwriteoff_v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.productref_v2.InformF1Type;
import ru.fsrar.wegais.productref_v2.InformF2TypeItem;


/**
 * Должна быть указанана или форма 1 или форма 2
 * 
 * <p>Java class for InformF1F2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InformF1F2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="InformF2" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}InformF2TypeItem"/>
 *         &lt;element name="InformF1" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}InformF1Type"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InformF1F2", propOrder = {
    "informF2",
    "informF1"
})
public class InformF1F2 {

    @XmlElement(name = "InformF2")
    protected InformF2TypeItem informF2;
    @XmlElement(name = "InformF1")
    protected InformF1Type informF1;

    /**
     * Gets the value of the informF2 property.
     * 
     * @return
     *     possible object is
     *     {@link InformF2TypeItem }
     *     
     */
    public InformF2TypeItem getInformF2() {
        return informF2;
    }

    /**
     * Sets the value of the informF2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformF2TypeItem }
     *     
     */
    public void setInformF2(InformF2TypeItem value) {
        this.informF2 = value;
    }

    /**
     * Gets the value of the informF1 property.
     * 
     * @return
     *     possible object is
     *     {@link InformF1Type }
     *     
     */
    public InformF1Type getInformF1() {
        return informF1;
    }

    /**
     * Sets the value of the informF1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformF1Type }
     *     
     */
    public void setInformF1(InformF1Type value) {
        this.informF1 = value;
    }

}
