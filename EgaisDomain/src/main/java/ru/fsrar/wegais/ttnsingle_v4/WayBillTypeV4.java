package ru.fsrar.wegais.ttnsingle_v4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusV2;
import ru.fsrar.wegais.clientref_v2.OrgInfoV2;
import ru.tts.util.DateNoTimeXmlAdapter;


/**
 * Товарно-Транспортная Накладная
 * 
 * <p>Java class for WayBillType_v4 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WayBillType_v4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Type" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}WbType"/>
 *                   &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="ShippingDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="Transport" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}TransportType" minOccurs="0"/>
 *                   &lt;element name="Shipper" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
 *                   &lt;element name="Consignee" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfo_v2"/>
 *                   &lt;element name="Base" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Note" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="VarField1" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="VarField2" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="VarField3" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
 *                   &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}PositionType" maxOccurs="unbounded"/>
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
@XmlType(name = "WayBillType_v4", propOrder = {
    "identity",
    "header",
    "content"
})
public class WayBillTypeV4 {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected WayBillTypeV4 .Header header;
    @XmlElement(name = "Content", required = true)
    protected WayBillTypeV4 .Content content;

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
     *     {@link WayBillTypeV4 .Header }
     *     
     */
    public WayBillTypeV4 .Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayBillTypeV4 .Header }
     *     
     */
    public void setHeader(WayBillTypeV4 .Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link WayBillTypeV4 .Content }
     *     
     */
    public WayBillTypeV4 .Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link WayBillTypeV4 .Content }
     *     
     */
    public void setContent(WayBillTypeV4 .Content value) {
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
     *         &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}PositionType" maxOccurs="unbounded"/>
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
        protected List<PositionType> position;

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
         * {@link PositionType }
         * 
         * 
         */
        public List<PositionType> getPosition() {
            if (position == null) {
                position = new ArrayList<PositionType>();
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
     *         &lt;element name="Type" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}WbType"/>
     *         &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="ShippingDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="Transport" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}TransportType" minOccurs="0"/>
     *         &lt;element name="Shipper" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
     *         &lt;element name="Consignee" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfo_v2"/>
     *         &lt;element name="Base" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Note" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="VarField1" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="VarField2" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="VarField3" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
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

        @XmlElement(name = "Type", required = true, defaultValue = "WBInvoiceFromMe")
        @XmlSchemaType(name = "string")
        protected WbType type;
        @XmlElement(name = "NUMBER", required = true)
        protected String number;
        @XmlElement(name = "Date", required = true)
        @XmlSchemaType(name = "date")
        @XmlJavaTypeAdapter(DateNoTimeXmlAdapter.class)
        protected XMLGregorianCalendar date;
        @XmlJavaTypeAdapter(DateNoTimeXmlAdapter.class)
        @XmlElement(name = "ShippingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar shippingDate;
        @XmlElement(name = "Transport")
        protected TransportType transport;
        @XmlElement(name = "Shipper", required = true)
        protected OrgInfoRusV2 shipper;
        @XmlElement(name = "Consignee", required = true)
        protected OrgInfoV2 consignee;
        @XmlElement(name = "Base")
        protected String base;
        @XmlElement(name = "Note")
        protected String note;
        @XmlElement(name = "VarField1")
        protected String varField1;
        @XmlElement(name = "VarField2")
        protected String varField2;
        @XmlElement(name = "VarField3")
        protected String varField3;

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
         *     {@link OrgInfoV2 }
         *     
         */
        public OrgInfoV2 getConsignee() {
            return consignee;
        }

        /**
         * Sets the value of the consignee property.
         * 
         * @param value
         *     allowed object is
         *     {@link OrgInfoV2 }
         *     
         */
        public void setConsignee(OrgInfoV2 value) {
            this.consignee = value;
        }

        /**
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBase(String value) {
            this.base = value;
        }

        /**
         * Gets the value of the note property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNote() {
            return note;
        }

        /**
         * Sets the value of the note property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNote(String value) {
            this.note = value;
        }

        /**
         * Gets the value of the varField1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVarField1() {
            return varField1;
        }

        /**
         * Sets the value of the varField1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVarField1(String value) {
            this.varField1 = value;
        }

        /**
         * Gets the value of the varField2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVarField2() {
            return varField2;
        }

        /**
         * Sets the value of the varField2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVarField2(String value) {
            this.varField2 = value;
        }

        /**
         * Gets the value of the varField3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVarField3() {
            return varField3;
        }

        /**
         * Sets the value of the varField3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVarField3(String value) {
            this.varField3 = value;
        }

    }

}
