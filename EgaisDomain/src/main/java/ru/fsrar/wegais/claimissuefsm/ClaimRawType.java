//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.claimissuefsm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * »звещение или справка по импортированному сырью
 * 
 * <p>Java class for ClaimRawType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClaimRawType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ClaimNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="ClaimDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
 *         &lt;element name="SumAdvancePayment" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType" minOccurs="0"/>
 *         &lt;element name="VolumeAnhydrous" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType" minOccurs="0"/>
 *         &lt;element name="ClaimNumberFNS" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="ClaimDateFNS" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
 *         &lt;element name="VolumeNotUsed" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimRawType", propOrder = {

})
public class ClaimRawType {

    @XmlElement(name = "ClaimNumber")
    protected String claimNumber;
    @XmlElement(name = "ClaimDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar claimDate;
    @XmlElement(name = "SumAdvancePayment")
    protected BigDecimal sumAdvancePayment;
    @XmlElement(name = "VolumeAnhydrous")
    protected BigDecimal volumeAnhydrous;
    @XmlElement(name = "ClaimNumberFNS")
    protected String claimNumberFNS;
    @XmlElement(name = "ClaimDateFNS")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar claimDateFNS;
    @XmlElement(name = "VolumeNotUsed", required = true)
    protected BigDecimal volumeNotUsed;

    /**
     * Gets the value of the claimNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimNumber() {
        return claimNumber;
    }

    /**
     * Sets the value of the claimNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimNumber(String value) {
        this.claimNumber = value;
    }

    /**
     * Gets the value of the claimDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClaimDate() {
        return claimDate;
    }

    /**
     * Sets the value of the claimDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClaimDate(XMLGregorianCalendar value) {
        this.claimDate = value;
    }

    /**
     * Gets the value of the sumAdvancePayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSumAdvancePayment() {
        return sumAdvancePayment;
    }

    /**
     * Sets the value of the sumAdvancePayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSumAdvancePayment(BigDecimal value) {
        this.sumAdvancePayment = value;
    }

    /**
     * Gets the value of the volumeAnhydrous property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeAnhydrous() {
        return volumeAnhydrous;
    }

    /**
     * Sets the value of the volumeAnhydrous property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeAnhydrous(BigDecimal value) {
        this.volumeAnhydrous = value;
    }

    /**
     * Gets the value of the claimNumberFNS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimNumberFNS() {
        return claimNumberFNS;
    }

    /**
     * Sets the value of the claimNumberFNS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimNumberFNS(String value) {
        this.claimNumberFNS = value;
    }

    /**
     * Gets the value of the claimDateFNS property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClaimDateFNS() {
        return claimDateFNS;
    }

    /**
     * Sets the value of the claimDateFNS property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClaimDateFNS(XMLGregorianCalendar value) {
        this.claimDateFNS = value;
    }

    /**
     * Gets the value of the volumeNotUsed property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeNotUsed() {
        return volumeNotUsed;
    }

    /**
     * Sets the value of the volumeNotUsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeNotUsed(BigDecimal value) {
        this.volumeNotUsed = value;
    }

}