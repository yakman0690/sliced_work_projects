//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.requestmanufacturerfsmforcheck;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Позиция
 * 
 * <p>Java class for PositionReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PositionReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="VidAP171fz" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="MarkType" type="{http://fsrar.ru/WEGAIS/Common}MarkGZTypeString"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PositionReportType", propOrder = {

})
public class PositionReportType {

    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "VidAP171fz", required = true)
    protected String vidAP171Fz;
    @XmlElement(name = "MarkType", required = true)
    protected String markType;
    @XmlElement(name = "Quantity", required = true)
    protected BigInteger quantity;

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentity(String value) {
        this.identity = value;
    }

    /**
     * Gets the value of the vidAP171Fz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVidAP171Fz() {
        return vidAP171Fz;
    }

    /**
     * Sets the value of the vidAP171Fz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVidAP171Fz(String value) {
        this.vidAP171Fz = value;
    }

    /**
     * Gets the value of the markType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkType() {
        return markType;
    }

    /**
     * Sets the value of the markType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkType(String value) {
        this.markType = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

}
