//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.ttnhistoryf2reg;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stepType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stepType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="lev" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Form2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentForm2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Shipper" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Consignee" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WBRegId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stepType", propOrder = {

})
public class StepType {

    @XmlElement(required = true)
    protected BigInteger lev;
    @XmlElement(name = "Form2", required = true)
    protected String form2;
    @XmlElement(required = true)
    protected String parentForm2;
    @XmlElement(name = "Shipper", required = true)
    protected String shipper;
    @XmlElement(name = "Consignee", required = true)
    protected String consignee;
    @XmlElement(name = "WBRegId", required = true)
    protected String wbRegId;
    @XmlElement(required = true)
    protected BigDecimal amount;

    /**
     * Gets the value of the lev property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLev() {
        return lev;
    }

    /**
     * Sets the value of the lev property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLev(BigInteger value) {
        this.lev = value;
    }

    /**
     * Gets the value of the form2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForm2() {
        return form2;
    }

    /**
     * Sets the value of the form2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForm2(String value) {
        this.form2 = value;
    }

    /**
     * Gets the value of the parentForm2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentForm2() {
        return parentForm2;
    }

    /**
     * Sets the value of the parentForm2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentForm2(String value) {
        this.parentForm2 = value;
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

    /**
     * Gets the value of the consignee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * Sets the value of the consignee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsignee(String value) {
        this.consignee = value;
    }

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

}
