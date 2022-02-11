package ru.fsrar.wegais.ttnsingle_v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Транспортный раздел
 * 
 * <p>Java class for TransportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ChangeOwnership" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}WbChangeOwnershipType"/>
 *         &lt;element name="TRAN_TYPE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_COMPANY" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRANSPORT_TYPE" type="{http://fsrar.ru/WEGAIS/TTNSingle_v4}WbCTransportType"/>
 *         &lt;element name="TRANSPORT_REGNUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="TRAN_TRAILER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_CUSTOMER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_DRIVER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_LOADPOINT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_UNLOADPOINT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_REDIRECT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_FORWARDER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
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
@XmlType(name = "TransportType", propOrder = {

})
public class TransportType {

    @XmlElement(name = "ChangeOwnership", required = true)
    @XmlSchemaType(name = "string")
    protected WbChangeOwnershipType changeOwnership;
    @XmlElement(name = "TRAN_TYPE", required = true)
    protected String trantype;
    @XmlElement(name = "TRAN_COMPANY")
    protected String trancompany;
    @XmlElement(name = "TRANSPORT_TYPE", required = true)
    @XmlSchemaType(name = "string")
    protected WbCTransportType transporttype;
    @XmlElement(name = "TRANSPORT_REGNUMBER")
    protected String transportregnumber;
    @XmlElement(name = "TRAN_TRAILER")
    protected String trantrailer;
    @XmlElement(name = "TRAN_CUSTOMER")
    protected String trancustomer;
    @XmlElement(name = "TRAN_DRIVER")
    protected String trandriver;
    @XmlElement(name = "TRAN_LOADPOINT")
    protected String tranloadpoint;
    @XmlElement(name = "TRAN_UNLOADPOINT")
    protected String tranunloadpoint;
    @XmlElement(name = "TRAN_REDIRECT")
    protected String tranredirect;
    @XmlElement(name = "TRAN_FORWARDER")
    protected String tranforwarder;

    /**
     * Gets the value of the changeOwnership property.
     * 
     * @return
     *     possible object is
     *     {@link WbChangeOwnershipType }
     *     
     */
    public WbChangeOwnershipType getChangeOwnership() {
        return changeOwnership;
    }

    /**
     * Sets the value of the changeOwnership property.
     * 
     * @param value
     *     allowed object is
     *     {@link WbChangeOwnershipType }
     *     
     */
    public void setChangeOwnership(WbChangeOwnershipType value) {
        this.changeOwnership = value;
    }

    /**
     * Gets the value of the trantype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTYPE() {
        return trantype;
    }

    /**
     * Sets the value of the trantype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTYPE(String value) {
        this.trantype = value;
    }

    /**
     * Gets the value of the trancompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANCOMPANY() {
        return trancompany;
    }

    /**
     * Sets the value of the trancompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANCOMPANY(String value) {
        this.trancompany = value;
    }

    /**
     * Gets the value of the transporttype property.
     * 
     * @return
     *     possible object is
     *     {@link WbCTransportType }
     *     
     */
    public WbCTransportType getTRANSPORTTYPE() {
        return transporttype;
    }

    /**
     * Sets the value of the transporttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link WbCTransportType }
     *     
     */
    public void setTRANSPORTTYPE(WbCTransportType value) {
        this.transporttype = value;
    }

    /**
     * Gets the value of the transportregnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSPORTREGNUMBER() {
        return transportregnumber;
    }

    /**
     * Sets the value of the transportregnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSPORTREGNUMBER(String value) {
        this.transportregnumber = value;
    }

    /**
     * Gets the value of the trantrailer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANTRAILER() {
        return trantrailer;
    }

    /**
     * Sets the value of the trantrailer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANTRAILER(String value) {
        this.trantrailer = value;
    }

    /**
     * Gets the value of the trancustomer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANCUSTOMER() {
        return trancustomer;
    }

    /**
     * Sets the value of the trancustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANCUSTOMER(String value) {
        this.trancustomer = value;
    }

    /**
     * Gets the value of the trandriver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANDRIVER() {
        return trandriver;
    }

    /**
     * Sets the value of the trandriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANDRIVER(String value) {
        this.trandriver = value;
    }

    /**
     * Gets the value of the tranloadpoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANLOADPOINT() {
        return tranloadpoint;
    }

    /**
     * Sets the value of the tranloadpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANLOADPOINT(String value) {
        this.tranloadpoint = value;
    }

    /**
     * Gets the value of the tranunloadpoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANUNLOADPOINT() {
        return tranunloadpoint;
    }

    /**
     * Sets the value of the tranunloadpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANUNLOADPOINT(String value) {
        this.tranunloadpoint = value;
    }

    /**
     * Gets the value of the tranredirect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANREDIRECT() {
        return tranredirect;
    }

    /**
     * Sets the value of the tranredirect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANREDIRECT(String value) {
        this.tranredirect = value;
    }

    /**
     * Gets the value of the tranforwarder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANFORWARDER() {
        return tranforwarder;
    }

    /**
     * Sets the value of the tranforwarder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANFORWARDER(String value) {
        this.tranforwarder = value;
    }

}
