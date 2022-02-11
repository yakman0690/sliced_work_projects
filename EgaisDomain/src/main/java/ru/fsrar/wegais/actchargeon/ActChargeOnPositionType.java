//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.actchargeon;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.productref.ProductInfo;


/**
 * Позиция
 * 
 * <p>Java class for ActChargeOnPositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActChargeOnPositionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="Product" type="{http://fsrar.ru/WEGAIS/ProductRef}ProductInfo"/>
 *         &lt;element name="Quantity" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType"/>
 *         &lt;element name="InformAB">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="InformABKey" type="{http://fsrar.ru/WEGAIS/ActChargeOn}InformABKeyType"/>
 *                   &lt;element name="InformABReg" type="{http://fsrar.ru/WEGAIS/ActChargeOn}InformABRegType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MarkCodeInfo" type="{http://fsrar.ru/WEGAIS/ActChargeOn}MarkCodeInfoType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActChargeOnPositionType", propOrder = {

})
public class ActChargeOnPositionType {

    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "Product", required = true)
    protected ProductInfo product;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;
    @XmlElement(name = "InformAB", required = true)
    protected ActChargeOnPositionType.InformAB informAB;
    @XmlElement(name = "MarkCodeInfo")
    protected MarkCodeInfoType markCodeInfo;

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
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link ProductInfo }
     *     
     */
    public ProductInfo getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInfo }
     *     
     */
    public void setProduct(ProductInfo value) {
        this.product = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the informAB property.
     * 
     * @return
     *     possible object is
     *     {@link ActChargeOnPositionType.InformAB }
     *     
     */
    public ActChargeOnPositionType.InformAB getInformAB() {
        return informAB;
    }

    /**
     * Sets the value of the informAB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActChargeOnPositionType.InformAB }
     *     
     */
    public void setInformAB(ActChargeOnPositionType.InformAB value) {
        this.informAB = value;
    }

    /**
     * Gets the value of the markCodeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MarkCodeInfoType }
     *     
     */
    public MarkCodeInfoType getMarkCodeInfo() {
        return markCodeInfo;
    }

    /**
     * Sets the value of the markCodeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkCodeInfoType }
     *     
     */
    public void setMarkCodeInfo(MarkCodeInfoType value) {
        this.markCodeInfo = value;
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
     *       &lt;choice>
     *         &lt;element name="InformABKey" type="{http://fsrar.ru/WEGAIS/ActChargeOn}InformABKeyType"/>
     *         &lt;element name="InformABReg" type="{http://fsrar.ru/WEGAIS/ActChargeOn}InformABRegType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "informABKey",
        "informABReg"
    })
    public static class InformAB {

        @XmlElement(name = "InformABKey")
        protected InformABKeyType informABKey;
        @XmlElement(name = "InformABReg")
        protected InformABRegType informABReg;

        /**
         * Gets the value of the informABKey property.
         * 
         * @return
         *     possible object is
         *     {@link InformABKeyType }
         *     
         */
        public InformABKeyType getInformABKey() {
            return informABKey;
        }

        /**
         * Sets the value of the informABKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link InformABKeyType }
         *     
         */
        public void setInformABKey(InformABKeyType value) {
            this.informABKey = value;
        }

        /**
         * Gets the value of the informABReg property.
         * 
         * @return
         *     possible object is
         *     {@link InformABRegType }
         *     
         */
        public InformABRegType getInformABReg() {
            return informABReg;
        }

        /**
         * Sets the value of the informABReg property.
         * 
         * @param value
         *     allowed object is
         *     {@link InformABRegType }
         *     
         */
        public void setInformABReg(InformABRegType value) {
            this.informABReg = value;
        }

    }

}