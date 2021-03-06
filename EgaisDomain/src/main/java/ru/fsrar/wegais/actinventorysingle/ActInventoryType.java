//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.actinventorysingle;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Акт инвентаризации
 * 
 * <p>Java class for ActInventoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActInventoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Number" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="DivisionName" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
 *                         &lt;maxLength value="255"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="InventoryBasis" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="InventoryBasisNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *                   &lt;element name="InventoryBasisDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="InventoryDateBegin" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="InventoryDateEnd" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *                   &lt;element name="Note" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="500"/>
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
 *                   &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/ActInventorySingle}ActInventoryPositionType" maxOccurs="unbounded"/>
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
@XmlType(name = "ActInventoryType", propOrder = {
    "identity",
    "header",
    "content"
})
public class ActInventoryType {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Header", required = true)
    protected ActInventoryType.Header header;
    @XmlElement(name = "Content", required = true)
    protected ActInventoryType.Content content;

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
     *     {@link ActInventoryType.Header }
     *     
     */
    public ActInventoryType.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActInventoryType.Header }
     *     
     */
    public void setHeader(ActInventoryType.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link ActInventoryType.Content }
     *     
     */
    public ActInventoryType.Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActInventoryType.Content }
     *     
     */
    public void setContent(ActInventoryType.Content value) {
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
     *         &lt;element name="Position" type="{http://fsrar.ru/WEGAIS/ActInventorySingle}ActInventoryPositionType" maxOccurs="unbounded"/>
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
        protected List<ActInventoryPositionType> position;

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
         * {@link ActInventoryPositionType }
         * 
         * 
         */
        public List<ActInventoryPositionType> getPosition() {
            if (position == null) {
                position = new ArrayList<ActInventoryPositionType>();
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
     *         &lt;element name="Number" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="DivisionName" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="InventoryBasis" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="InventoryBasisNumber" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
     *         &lt;element name="InventoryBasisDate" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="InventoryDateBegin" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="InventoryDateEnd" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
     *         &lt;element name="Note" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="500"/>
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

        @XmlElement(name = "Number", required = true)
        protected String number;
        @XmlElement(name = "DivisionName")
        protected String divisionName;
        @XmlElement(name = "InventoryBasis", required = true)
        protected String inventoryBasis;
        @XmlElement(name = "InventoryBasisNumber", required = true)
        protected String inventoryBasisNumber;
        @XmlElement(name = "InventoryBasisDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar inventoryBasisDate;
        @XmlElement(name = "InventoryDateBegin", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar inventoryDateBegin;
        @XmlElement(name = "InventoryDateEnd", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar inventoryDateEnd;
        @XmlElement(name = "Note")
        protected String note;

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumber() {
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
        public void setNumber(String value) {
            this.number = value;
        }

        /**
         * Gets the value of the divisionName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDivisionName() {
            return divisionName;
        }

        /**
         * Sets the value of the divisionName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDivisionName(String value) {
            this.divisionName = value;
        }

        /**
         * Gets the value of the inventoryBasis property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInventoryBasis() {
            return inventoryBasis;
        }

        /**
         * Sets the value of the inventoryBasis property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInventoryBasis(String value) {
            this.inventoryBasis = value;
        }

        /**
         * Gets the value of the inventoryBasisNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInventoryBasisNumber() {
            return inventoryBasisNumber;
        }

        /**
         * Sets the value of the inventoryBasisNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInventoryBasisNumber(String value) {
            this.inventoryBasisNumber = value;
        }

        /**
         * Gets the value of the inventoryBasisDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getInventoryBasisDate() {
            return inventoryBasisDate;
        }

        /**
         * Sets the value of the inventoryBasisDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setInventoryBasisDate(XMLGregorianCalendar value) {
            this.inventoryBasisDate = value;
        }

        /**
         * Gets the value of the inventoryDateBegin property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getInventoryDateBegin() {
            return inventoryDateBegin;
        }

        /**
         * Sets the value of the inventoryDateBegin property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setInventoryDateBegin(XMLGregorianCalendar value) {
            this.inventoryDateBegin = value;
        }

        /**
         * Gets the value of the inventoryDateEnd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getInventoryDateEnd() {
            return inventoryDateEnd;
        }

        /**
         * Sets the value of the inventoryDateEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setInventoryDateEnd(XMLGregorianCalendar value) {
            this.inventoryDateEnd = value;
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

    }

}
