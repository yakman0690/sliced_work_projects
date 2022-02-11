//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.debtabsence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusClaimIssue;


/**
 * Справка
 * 
 * <p>Java class for DebtAbsenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DebtAbsenceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="Client" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
 *                   &lt;element name="Issuer" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString" minOccurs="0"/>
 *                   &lt;element name="DateDebtAbsence" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="ClaimIssueFSMNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="ClaimIssueFSMDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtAbsenceType", propOrder = {
    "identity",
    "header"
})
public class DebtAbsenceType {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected DebtAbsenceType.Header header;

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
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link DebtAbsenceType.Header }
     *     
     */
    public DebtAbsenceType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebtAbsenceType.Header }
     *     
     */
    public void setHeader(DebtAbsenceType.Header value) {
        this.header = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="Client" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
     *         &lt;element name="Issuer" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString" minOccurs="0"/>
     *         &lt;element name="DateDebtAbsence" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="ClaimIssueFSMNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="ClaimIssueFSMDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Header {

        @XmlElement(name = "NUMBER", required = true)
        protected String number;
        @XmlElement(name = "Date", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "Client", required = true)
        protected OrgInfoRusClaimIssue client;
        @XmlElement(name = "Issuer")
        protected String issuer;
        @XmlElement(name = "DateDebtAbsence", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateDebtAbsence;
        @XmlElement(name = "ClaimIssueFSMNumber", required = true)
        protected String claimIssueFSMNumber;
        @XmlElement(name = "ClaimIssueFSMDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar claimIssueFSMDate;

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
         * Gets the value of the client property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public OrgInfoRusClaimIssue getClient() {
            return client;
        }

        /**
         * Sets the value of the client property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public void setClient(OrgInfoRusClaimIssue value) {
            this.client = value;
        }

        /**
         * Gets the value of the issuer property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIssuer() {
            return issuer;
        }

        /**
         * Sets the value of the issuer property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIssuer(String value) {
            this.issuer = value;
        }

        /**
         * Gets the value of the dateDebtAbsence property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateDebtAbsence() {
            return dateDebtAbsence;
        }

        /**
         * Sets the value of the dateDebtAbsence property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateDebtAbsence(XMLGregorianCalendar value) {
            this.dateDebtAbsence = value;
        }

        /**
         * Gets the value of the claimIssueFSMNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClaimIssueFSMNumber() {
            return claimIssueFSMNumber;
        }

        /**
         * Sets the value of the claimIssueFSMNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClaimIssueFSMNumber(String value) {
            this.claimIssueFSMNumber = value;
        }

        /**
         * Gets the value of the claimIssueFSMDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getClaimIssueFSMDate() {
            return claimIssueFSMDate;
        }

        /**
         * Sets the value of the claimIssueFSMDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setClaimIssueFSMDate(XMLGregorianCalendar value) {
            this.claimIssueFSMDate = value;
        }

    }

}