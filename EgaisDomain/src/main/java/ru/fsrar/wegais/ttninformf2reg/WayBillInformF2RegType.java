//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.ttninformf2reg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusV2;


/**
 * Квитанция о регистрации справок 2 для Товарно-Транспортной Накладной
 * 
 * <p>Java class for WayBillInformF2RegType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WayBillInformF2RegType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *                   &lt;element name="WBRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="EGAISFixNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *                   &lt;element name="EGAISFixDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
 *                   &lt;element name="WBNUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="WBDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="Shipper" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
 *                   &lt;element name="Consignee" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
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
 *                   &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/TTNInformF2Reg}InformF2PositionType" maxOccurs="unbounded"/>
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
@XmlType(name = "WayBillInformF2RegType", propOrder = {
    "header",
    "content"
})
public class WayBillInformF2RegType {

    @XmlElement(name = "Header", required = true)
    protected WayBillInformF2RegType.Header header;
    @XmlElement(name = "Content", required = true)
    protected WayBillInformF2RegType.Content content;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link WayBillInformF2RegType.Header }
     *     
     */
    public WayBillInformF2RegType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayBillInformF2RegType.Header }
     *     
     */
    public void setHeader(WayBillInformF2RegType.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link WayBillInformF2RegType.Content }
     *     
     */
    public WayBillInformF2RegType.Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayBillInformF2RegType.Content }
     *     
     */
    public void setContent(WayBillInformF2RegType.Content value) {
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
     *         &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/TTNInformF2Reg}InformF2PositionType" maxOccurs="unbounded"/>
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
        protected List<InformF2PositionType> position;

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
         * {@link InformF2PositionType }
         * 
         * 
         */
        public List<InformF2PositionType> getPosition() {
            if (position == null) {
                position = new ArrayList<InformF2PositionType>();
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
     *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
     *         &lt;element name="WBRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="EGAISFixNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
     *         &lt;element name="EGAISFixDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime" minOccurs="0"/>
     *         &lt;element name="WBNUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="WBDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="Shipper" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
     *         &lt;element name="Consignee" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
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

        @XmlElement(name = "Identity")
        protected String identity;
        @XmlElement(name = "WBRegId", required = true)
        protected String wbRegId;
        @XmlElement(name = "EGAISFixNumber")
        protected String egaisFixNumber;
        @XmlElement(name = "EGAISFixDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar egaisFixDate;
        @XmlElement(name = "WBNUMBER", required = true)
        protected String wbnumber;
        @XmlElement(name = "WBDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar wbDate;
        @XmlElement(name = "Shipper", required = true)
        protected OrgInfoRusV2 shipper;
        @XmlElement(name = "Consignee", required = true)
        protected OrgInfoRusV2 consignee;

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
         * Gets the value of the egaisFixNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEGAISFixNumber() {
            return egaisFixNumber;
        }

        /**
         * Sets the value of the egaisFixNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEGAISFixNumber(String value) {
            this.egaisFixNumber = value;
        }

        /**
         * Gets the value of the egaisFixDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEGAISFixDate() {
            return egaisFixDate;
        }

        /**
         * Sets the value of the egaisFixDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEGAISFixDate(XMLGregorianCalendar value) {
            this.egaisFixDate = value;
        }

        /**
         * Gets the value of the wbnumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWBNUMBER() {
            return wbnumber;
        }

        /**
         * Sets the value of the wbnumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWBNUMBER(String value) {
            this.wbnumber = value;
        }

        /**
         * Gets the value of the wbDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getWBDate() {
            return wbDate;
        }

        /**
         * Sets the value of the wbDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setWBDate(XMLGregorianCalendar value) {
            this.wbDate = value;
        }

        /**
         * Gets the value of the shipper property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusV2 }
         *     
         */
        public OrgInfoRusV2 getShipper() {
            return shipper;
        }

        /**
         * Sets the value of the shipper property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusV2 }
         *     
         */
        public void setShipper(OrgInfoRusV2 value) {
            this.shipper = value;
        }

        /**
         * Gets the value of the consignee property.
         * 
         * @return
         *     possible object is
         *     {@link OrgInfoRusV2 }
         *     
         */
        public OrgInfoRusV2 getConsignee() {
            return consignee;
        }

        /**
         * Sets the value of the consignee property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoRusV2 }
         *     
         */
        public void setConsignee(OrgInfoRusV2 value) {
            this.consignee = value;
        }

    }

}
