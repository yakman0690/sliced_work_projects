//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.notificationsbeginningturnover;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.productref_v2.WbIngredientType;


/**
 * Позиция
 * 
 * <p>Java class for PositionCompositionProductsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PositionCompositionProductsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="IngredientType" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}WbIngredientType"/>
 *         &lt;element name="IngredientCode" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="IngredientName" minOccurs="0">
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
@XmlType(name = "PositionCompositionProductsType", propOrder = {

})
public class PositionCompositionProductsType {

    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "IngredientType", required = true)
    @XmlSchemaType(name = "string")
    protected WbIngredientType ingredientType;
    @XmlElement(name = "IngredientCode")
    protected String ingredientCode;
    @XmlElement(name = "IngredientName")
    protected String ingredientName;

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
     * Gets the value of the ingredientType property.
     * 
     * @return
     *     possible object is
     *     {@link WbIngredientType }
     *     
     */
    public WbIngredientType getIngredientType() {
        return ingredientType;
    }

    /**
     * Sets the value of the ingredientType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WbIngredientType }
     *     
     */
    public void setIngredientType(WbIngredientType value) {
        this.ingredientType = value;
    }

    /**
     * Gets the value of the ingredientCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIngredientCode() {
        return ingredientCode;
    }

    /**
     * Sets the value of the ingredientCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIngredientCode(String value) {
        this.ingredientCode = value;
    }

    /**
     * Gets the value of the ingredientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIngredientName() {
        return ingredientName;
    }

    /**
     * Sets the value of the ingredientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIngredientName(String value) {
        this.ingredientName = value;
    }

}
