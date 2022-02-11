//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.actconfirmonlineorder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.productref_v2.ProductInfoV2;


/**
 * Позиция
 * 
 * <p>Java class for ActConfirmOnlineOrderPositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActConfirmOnlineOrderPositionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="Product" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}ProductInfo_v2"/>
 *         &lt;element name="Quantity" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType"/>
 *         &lt;element name="SumSale" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="F2Detail">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Form2" type="{http://fsrar.ru/WEGAIS/ActConfirmOnlineOrder}F2DetailType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "ActConfirmOnlineOrderPositionType", propOrder = {

})
public class ActConfirmOnlineOrderPositionType {

    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "Product", required = true)
    protected ProductInfoV2 product;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;
    @XmlElement(name = "SumSale", required = true)
    protected BigDecimal sumSale;
    @XmlElement(name = "F2Detail", required = true)
    protected ActConfirmOnlineOrderPositionType.F2Detail f2Detail;

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
     *     {@link ProductInfoV2 }
     *     
     */
    public ProductInfoV2 getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInfoV2 }
     *     
     */
    public void setProduct(ProductInfoV2 value) {
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
     * Gets the value of the sumSale property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSumSale() {
        return sumSale;
    }

    /**
     * Sets the value of the sumSale property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSumSale(BigDecimal value) {
        this.sumSale = value;
    }

    /**
     * Gets the value of the f2Detail property.
     * 
     * @return
     *     possible object is
     *     {@link ActConfirmOnlineOrderPositionType.F2Detail }
     *     
     */
    public ActConfirmOnlineOrderPositionType.F2Detail getF2Detail() {
        return f2Detail;
    }

    /**
     * Sets the value of the f2Detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActConfirmOnlineOrderPositionType.F2Detail }
     *     
     */
    public void setF2Detail(ActConfirmOnlineOrderPositionType.F2Detail value) {
        this.f2Detail = value;
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
     *         &lt;element name="Form2" type="{http://fsrar.ru/WEGAIS/ActConfirmOnlineOrder}F2DetailType" maxOccurs="unbounded"/>
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
        "form2"
    })
    public static class F2Detail {

        @XmlElement(name = "Form2", required = true)
        protected List<F2DetailType> form2;

        /**
         * Gets the value of the form2 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the form2 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getForm2().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link F2DetailType }
         * 
         * 
         */
        public List<F2DetailType> getForm2() {
            if (form2 == null) {
                form2 = new ArrayList<F2DetailType>();
            }
            return this.form2;
        }

    }

}
