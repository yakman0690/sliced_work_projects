//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.replynoanswerttn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for NoAnswerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NoAnswerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WbRegID" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="ttnNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="ttnDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *         &lt;element name="Shipper" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NoAnswerType", propOrder = {
    "wbRegID",
    "ttnNumber",
    "ttnDate",
    "shipper"
})
public class NoAnswerType {

    @XmlElement(name = "WbRegID", required = true)
    protected String wbRegID;
    @XmlElement(required = true)
    protected String ttnNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ttnDate;
    @XmlElement(name = "Shipper", required = true)
    protected String shipper;

    /**
     * Gets the value of the wbRegID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWbRegID() {
        return wbRegID;
    }

    /**
     * Sets the value of the wbRegID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWbRegID(String value) {
        this.wbRegID = value;
    }

    /**
     * Gets the value of the ttnNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTtnNumber() {
        return ttnNumber;
    }

    /**
     * Sets the value of the ttnNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTtnNumber(String value) {
        this.ttnNumber = value;
    }

    /**
     * Gets the value of the ttnDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTtnDate() {
        return ttnDate;
    }

    /**
     * Sets the value of the ttnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTtnDate(XMLGregorianCalendar value) {
        this.ttnDate = value;
    }

    /**
     * Gets the value of the shipper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipper() {
        return shipper;
    }

    /**
     * Sets the value of the shipper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipper(String value) {
        this.shipper = value;
    }

}
