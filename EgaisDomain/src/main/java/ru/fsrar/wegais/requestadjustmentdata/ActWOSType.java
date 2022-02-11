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
import ru.fsrar.wegais.commonenum.TypeWriteOff;


/**
 * ��� �������� �� ��������� ����
 * 
 * <p>Java class for ActWOSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActWOSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="AWOSRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="ActNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="ActDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *         &lt;element name="TypeWriteOff" type="{http://fsrar.ru/WEGAIS/CommonEnum}TypeWriteOff"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActWOSType", propOrder = {

})
public class ActWOSType {

    @XmlElement(name = "AWOSRegId", required = true)
    protected String awosRegId;
    @XmlElement(name = "ActNumber", required = true)
    protected String actNumber;
    @XmlElement(name = "ActDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actDate;
    @XmlElement(name = "TypeWriteOff", required = true)
    @XmlSchemaType(name = "string")
    protected TypeWriteOff typeWriteOff;

    /**
     * Gets the value of the awosRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAWOSRegId() {
        return awosRegId;
    }

    /**
     * Sets the value of the awosRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAWOSRegId(String value) {
        this.awosRegId = value;
    }

    /**
     * Gets the value of the actNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActNumber() {
        return actNumber;
    }

    /**
     * Sets the value of the actNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActNumber(String value) {
        this.actNumber = value;
    }

    /**
     * Gets the value of the actDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActDate() {
        return actDate;
    }

    /**
     * Sets the value of the actDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActDate(XMLGregorianCalendar value) {
        this.actDate = value;
    }

    /**
     * Gets the value of the typeWriteOff property.
     * 
     * @return
     *     possible object is
     *     {@link TypeWriteOff }
     *     
     */
    public TypeWriteOff getTypeWriteOff() {
        return typeWriteOff;
    }

    /**
     * Sets the value of the typeWriteOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeWriteOff }
     *     
     */
    public void setTypeWriteOff(TypeWriteOff value) {
        this.typeWriteOff = value;
    }

}