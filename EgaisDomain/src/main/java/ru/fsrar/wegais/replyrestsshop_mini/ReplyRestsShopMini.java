//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.replyrestsshop_mini;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ответ на запрос об остатках по торговому залу (сокращенный)
 * 
 * <p>Java class for ReplyRestsShop_Mini complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReplyRestsShop_Mini">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RestsDate" type="{http://fsrar.ru/WEGAIS/Common}DateWTime"/>
 *         &lt;element name="Products" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ShopPosition" type="{http://fsrar.ru/WEGAIS/ReplyRestsShop_Mini}ShopPositionType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ReplyRestsShop_Mini", propOrder = {
    "restsDate",
    "products"
})
public class ReplyRestsShopMini {

    @XmlElement(name = "RestsDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar restsDate;
    @XmlElement(name = "Products")
    protected ReplyRestsShopMini.Products products;

    /**
     * Gets the value of the restsDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRestsDate() {
        return restsDate;
    }

    /**
     * Sets the value of the restsDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRestsDate(XMLGregorianCalendar value) {
        this.restsDate = value;
    }

    /**
     * Gets the value of the products property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyRestsShopMini.Products }
     *     
     */
    public ReplyRestsShopMini.Products getProducts() {
        return products;
    }

    /**
     * Sets the value of the products property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyRestsShopMini.Products }
     *     
     */
    public void setProducts(ReplyRestsShopMini.Products value) {
        this.products = value;
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
     *         &lt;element name="ShopPosition" type="{http://fsrar.ru/WEGAIS/ReplyRestsShop_Mini}ShopPositionType" maxOccurs="unbounded" minOccurs="0"/>
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
        "shopPosition"
    })
    public static class Products {

        @XmlElement(name = "ShopPosition")
        protected List<ShopPositionType> shopPosition;

        /**
         * Gets the value of the shopPosition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the shopPosition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getShopPosition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ShopPositionType }
         * 
         * 
         */
        public List<ShopPositionType> getShopPosition() {
            if (shopPosition == null) {
                shopPosition = new ArrayList<ShopPositionType>();
            }
            return this.shopPosition;
        }

    }

}
