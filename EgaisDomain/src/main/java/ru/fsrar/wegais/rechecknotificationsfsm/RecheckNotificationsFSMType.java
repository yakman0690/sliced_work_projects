//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.rechecknotificationsfsm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusClaimIssue;


/**
 * уведомление о повторной проверке
 * 
 * <p>Java class for RecheckNotificationsFSMType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecheckNotificationsFSMType">
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
 *                   &lt;element name="RequestNUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="RequestDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="RequestFSM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="Declarer" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
 *                   &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "RecheckNotificationsFSMType", propOrder = {
    "identity",
    "header"
})
public class RecheckNotificationsFSMType {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected RecheckNotificationsFSMType.Header header;

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
     *     {@link RecheckNotificationsFSMType.Header }
     *     
     */
    public RecheckNotificationsFSMType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecheckNotificationsFSMType.Header }
     *     
     */
    public void setHeader(RecheckNotificationsFSMType.Header value) {
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
     *         &lt;element name="RequestNUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="RequestDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="RequestFSM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="Declarer" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
     *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        @XmlElement(name = "RequestNUMBER", required = true)
        protected String requestNUMBER;
        @XmlElement(name = "RequestDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar requestDate;
        @XmlElement(name = "RequestFSM", required = true)
        protected String requestFSM;
        @XmlElement(name = "Declarer", required = true)
        protected OrgInfoRusClaimIssue declarer;
        @XmlElement(name = "Comment", required = true)
        protected String comment;

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
         * Gets the value of the requestNUMBER property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestNUMBER() {
            return requestNUMBER;
        }

        /**
         * Sets the value of the requestNUMBER property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestNUMBER(String value) {
            this.requestNUMBER = value;
        }

        /**
         * Gets the value of the requestDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRequestDate() {
            return requestDate;
        }

        /**
         * Sets the value of the requestDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRequestDate(XMLGregorianCalendar value) {
            this.requestDate = value;
        }

        /**
         * Gets the value of the requestFSM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestFSM() {
            return requestFSM;
        }

        /**
         * Sets the value of the requestFSM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestFSM(String value) {
            this.requestFSM = value;
        }

        /**
         * Gets the value of the declarer property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public OrgInfoRusClaimIssue getDeclarer() {
            return declarer;
        }

        /**
         * Sets the value of the declarer property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public void setDeclarer(OrgInfoRusClaimIssue value) {
            this.declarer = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

    }

}
