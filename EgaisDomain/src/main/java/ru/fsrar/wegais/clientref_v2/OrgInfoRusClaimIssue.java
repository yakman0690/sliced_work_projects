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
 * Российские организации
 * 
 * <p>Java class for OrgInfoRus_ClaimIssue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrgInfoRus_ClaimIssue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="UL" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}ULType_ClaimIssue"/>
 *         &lt;element name="FL" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}FLType_ClaimIssue"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrgInfoRus_ClaimIssue", propOrder = {
    "ul",
    "fl"
})
public class OrgInfoRusClaimIssue {

    @XmlElement(name = "UL")
    protected ULTypeClaimIssue ul;
    @XmlElement(name = "FL")
    protected FLTypeClaimIssue fl;

    /**
     * Gets the value of the ul property.
     * 
     * @return
     *     possible object is
     *     {@link ULTypeClaimIssue }
     *     
     */
    public ULTypeClaimIssue getUL() {
        return ul;
    }

    /**
     * Sets the value of the ul property.
     * 
     * @param value
     *     allowed object is
     *     {@link ULTypeClaimIssue }
     *     
     */
    public void setUL(ULTypeClaimIssue value) {
        this.ul = value;
    }

    /**
     * Gets the value of the fl property.
     * 
     * @return
     *     possible object is
     *     {@link FLTypeClaimIssue }
     *     
     */
    public FLTypeClaimIssue getFL() {
        return fl;
    }

    /**
     * Sets the value of the fl property.
     * 
     * @param value
     *     allowed object is
     *     {@link FLTypeClaimIssue }
     *     
     */
    public void setFL(FLTypeClaimIssue value) {
        this.fl = value;
    }

}
