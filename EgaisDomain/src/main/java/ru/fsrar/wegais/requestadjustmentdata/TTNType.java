//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.requestadjustmentdata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.ttnsingle_v4.TransportType;


/**
 * Товарно-транспортная накладная
 * 
 * <p>Java class for TTNType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTNType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="WBRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
 *         &lt;element name="ShippingDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://fsrar.ru/WEGAIS/RequestAdjustmentData}WbType" minOccurs="0"/>
 *         &lt;element name="Transport" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}TransportType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTNType", propOrder = {

})
public class TTNType {

    @XmlElement(name = "WBRegId", required = true)
    protected String wbRegId;
    @XmlElement(name = "NUMBER")
    protected String number;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "ShippingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar shippingDate;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected WbType type;
    @XmlElement(name = "Transport")
    protected TransportType transport;

    /**
     * Gets the value of the wbRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWBRegId() {
        return wbRegId;
    }

    /**
     * Sets the value of the wbRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWBRegId(String value) {
        this.wbRegId = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMBER() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMBER(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the shippingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getShippingDate() {
        return shippingDate;
    }

    /**
     * Sets the value of the shippingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setShippingDate(XMLGregorianCalendar value) {
        this.shippingDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link WbType }
     *     
     */
    public WbType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link WbType }
     *     
     */
    public void setType(WbType value) {
        this.type = value;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link TransportType }
     *     
     */
    public TransportType getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportType }
     *     
     */
    public void setTransport(TransportType value) {
        this.transport = value;
    }

}
