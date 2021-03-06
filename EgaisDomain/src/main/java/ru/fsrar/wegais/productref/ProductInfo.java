//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.productref;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.clientref.OrgInfo;


/**
 * <p>Java class for ProductInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://fsrar.ru/WEGAIS/ProductRef}ProductType" minOccurs="0"/>
 *         &lt;element name="FullName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ShortName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AlcCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Capacity" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType" minOccurs="0"/>
 *         &lt;element name="AlcVolume" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Producer" type="{http://fsrar.ru/WEGAIS/ClientRef}OrgInfo" minOccurs="0"/>
 *         &lt;element name="Importer" type="{http://fsrar.ru/WEGAIS/ClientRef}OrgInfo" minOccurs="0"/>
 *         &lt;element name="ProductVCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
 *               &lt;maxLength value="5"/>
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
@XmlType(name = "ProductInfo", propOrder = {

})
public class ProductInfo {

    @XmlElement(name = "Identity")
    protected String identity;
    @XmlElement(name = "Type")
    @XmlSchemaType(name = "string")
    protected ProductType type;
    @XmlElement(name = "FullName", required = true)
    protected String fullName;
    @XmlElement(name = "ShortName")
    protected String shortName;
    @XmlElement(name = "AlcCode", required = true)
    protected String alcCode;
    @XmlElement(name = "Capacity")
    protected BigDecimal capacity;
    @XmlElement(name = "AlcVolume")
    protected BigDecimal alcVolume;
    @XmlElement(name = "Producer")
    protected OrgInfo producer;
    @XmlElement(name = "Importer")
    protected OrgInfo importer;
    @XmlElement(name = "ProductVCode", required = true)
    protected String productVCode;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ProductType }
     *     
     */
    public ProductType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType }
     *     
     */
    public void setType(ProductType value) {
        this.type = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the alcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlcCode() {
        return alcCode;
    }

    /**
     * Sets the value of the alcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlcCode(String value) {
        this.alcCode = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCapacity(BigDecimal value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the alcVolume property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAlcVolume() {
        return alcVolume;
    }

    /**
     * Sets the value of the alcVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAlcVolume(BigDecimal value) {
        this.alcVolume = value;
    }

    /**
     * Gets the value of the producer property.
     * 
     * @return
     *     possible object is
     *     {@link OrgInfo }
     *     
     */
    public OrgInfo getProducer() {
        return producer;
    }

    /**
     * Sets the value of the producer property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgInfo }
     *     
     */
    public void setProducer(OrgInfo value) {
        this.producer = value;
    }

    /**
     * Gets the value of the importer property.
     * 
     * @return
     *     possible object is
     *     {@link OrgInfo }
     *     
     */
    public OrgInfo getImporter() {
        return importer;
    }

    /**
     * Sets the value of the importer property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgInfo }
     *     
     */
    public void setImporter(OrgInfo value) {
        this.importer = value;
    }

    /**
     * Gets the value of the productVCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductVCode() {
        return productVCode;
    }

    /**
     * Sets the value of the productVCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductVCode(String value) {
        this.productVCode = value;
    }

}
