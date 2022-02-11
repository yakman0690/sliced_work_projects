package ru.fsrar.wegais.ticketrmcheck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Квитанция
 * 
 * <p>Java class for TicketRMCheckType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TicketRMCheckType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="TicketDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="RequestFSM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="CheckResult" type="{http://fsrar.ru/WEGAIS/TicketRMCheck}ConclusionType"/>
 *                   &lt;element name="Comments" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString2000" minOccurs="0"/>
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
@XmlType(name = "TicketRMCheckType", propOrder = {
    "identity",
    "header"
})
public class TicketRMCheckType {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected TicketRMCheckType.Header header;

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
     *     {@link TicketRMCheckType.Header }
     *     
     */
    public TicketRMCheckType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketRMCheckType.Header }
     *     
     */
    public void setHeader(TicketRMCheckType.Header value) {
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
     *         &lt;element name="TicketDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="RequestFSM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="CheckResult" type="{http://fsrar.ru/WEGAIS/TicketRMCheck}ConclusionType"/>
     *         &lt;element name="Comments" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString2000" minOccurs="0"/>
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

        @XmlElement(name = "TicketDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar ticketDate;
        @XmlElement(name = "RequestFSM", required = true)
        protected String requestFSM;
        @XmlElement(name = "CheckResult", required = true)
        @XmlSchemaType(name = "string")
        protected ConclusionType checkResult;
        @XmlElement(name = "Comments")
        protected String comments;

        /**
         * Gets the value of the ticketDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTicketDate() {
            return ticketDate;
        }

        /**
         * Sets the value of the ticketDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTicketDate(XMLGregorianCalendar value) {
            this.ticketDate = value;
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
         * Gets the value of the checkResult property.
         * 
         * @return
         *     possible object is
         *     {@link ConclusionType }
         *     
         */
        public ConclusionType getCheckResult() {
            return checkResult;
        }

        /**
         * Sets the value of the checkResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link ConclusionType }
         *     
         */
        public void setCheckResult(ConclusionType value) {
            this.checkResult = value;
        }

        /**
         * Gets the value of the comments property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComments() {
            return comments;
        }

        /**
         * Sets the value of the comments property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComments(String value) {
            this.comments = value;
        }

    }

}
