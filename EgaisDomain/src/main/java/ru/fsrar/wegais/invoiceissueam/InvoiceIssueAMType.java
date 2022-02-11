//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.invoiceissueam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusClaimIssue;


/**
 * квитанция о выдаче АМ для импорта АП
 * 
 * <p>Java class for InvoiceIssueAMType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvoiceIssueAMType">
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
 *                   &lt;element name="Importer" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
 *                   &lt;element name="CustomsDepartment" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
 *                   &lt;element name="RequestAM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="ActualShipmentDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="TotalQuantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Content">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/InvoiceIssueAM}PositionInvoiceIssueAMType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
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
@XmlType(name = "InvoiceIssueAMType", propOrder = {
    "identity",
    "header",
    "content"
})
public class InvoiceIssueAMType {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected InvoiceIssueAMType.Header header;
    @XmlElement(name = "Content", required = true)
    protected InvoiceIssueAMType.Content content;

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
     *     {@link InvoiceIssueAMType.Header }
     *     
     */
    public InvoiceIssueAMType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceIssueAMType.Header }
     *     
     */
    public void setHeader(InvoiceIssueAMType.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceIssueAMType.Content }
     *     
     */
    public InvoiceIssueAMType.Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceIssueAMType.Content }
     *     
     */
    public void setContent(InvoiceIssueAMType.Content value) {
        this.content = value;
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
     *       &lt;sequence>
     *         &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/InvoiceIssueAM}PositionInvoiceIssueAMType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "position"
    })
    public static class Content {

        @XmlElement(name = "Position", required = true)
        protected List<PositionInvoiceIssueAMType> position;

        /**
         * Gets the value of the position property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the position property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPosition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PositionInvoiceIssueAMType }
         * 
         * 
         */
        public List<PositionInvoiceIssueAMType> getPosition() {
            if (position == null) {
                position = new ArrayList<PositionInvoiceIssueAMType>();
            }
            return this.position;
        }

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
     *         &lt;element name="Importer" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
     *         &lt;element name="CustomsDepartment" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_ClaimIssue"/>
     *         &lt;element name="RequestAM" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="ActualShipmentDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="TotalQuantity" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
        @XmlElement(name = "Importer", required = true)
        protected OrgInfoRusClaimIssue importer;
        @XmlElement(name = "CustomsDepartment", required = true)
        protected OrgInfoRusClaimIssue customsDepartment;
        @XmlElement(name = "RequestAM", required = true)
        protected String requestAM;
        @XmlElement(name = "ActualShipmentDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar actualShipmentDate;
        @XmlElement(name = "TotalQuantity", required = true)
        protected BigInteger totalQuantity;

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
         * Gets the value of the importer property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public OrgInfoRusClaimIssue getImporter() {
            return importer;
        }

        /**
         * Sets the value of the importer property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public void setImporter(OrgInfoRusClaimIssue value) {
            this.importer = value;
        }

        /**
         * Gets the value of the customsDepartment property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public OrgInfoRusClaimIssue getCustomsDepartment() {
            return customsDepartment;
        }

        /**
         * Sets the value of the customsDepartment property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusClaimIssue }
         *     
         */
        public void setCustomsDepartment(OrgInfoRusClaimIssue value) {
            this.customsDepartment = value;
        }

        /**
         * Gets the value of the requestAM property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestAM() {
            return requestAM;
        }

        /**
         * Sets the value of the requestAM property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestAM(String value) {
            this.requestAM = value;
        }

        /**
         * Gets the value of the actualShipmentDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getActualShipmentDate() {
            return actualShipmentDate;
        }

        /**
         * Sets the value of the actualShipmentDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setActualShipmentDate(XMLGregorianCalendar value) {
            this.actualShipmentDate = value;
        }

        /**
         * Gets the value of the totalQuantity property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTotalQuantity() {
            return totalQuantity;
        }

        /**
         * Sets the value of the totalQuantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTotalQuantity(BigInteger value) {
            this.totalQuantity = value;
        }

    }

}