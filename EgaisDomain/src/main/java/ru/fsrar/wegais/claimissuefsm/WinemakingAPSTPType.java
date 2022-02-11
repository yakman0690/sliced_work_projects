//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.claimissuefsm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.productref_v2.ProductInfoAsiiuV2;


/**
 * <p>Java class for WinemakingAPSTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WinemakingAPSTPType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Raw" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}ProductInfoAsiiu_v2"/>
 *         &lt;element name="VolumeRest" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="VolumeGrapeCollect" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="VolumeGrapeUse" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="VolumeToAgingRaw" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="VolumeFromAgingRaw" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="VolumeUsedgRaw" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="TotalRaw" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WinemakingAPSTPType", propOrder = {

})
public class WinemakingAPSTPType {

    @XmlElement(name = "Raw", required = true)
    protected ProductInfoAsiiuV2 raw;
    @XmlElement(name = "VolumeRest", required = true)
    protected BigDecimal volumeRest;
    @XmlElement(name = "VolumeGrapeCollect", required = true)
    protected BigDecimal volumeGrapeCollect;
    @XmlElement(name = "VolumeGrapeUse", required = true)
    protected BigDecimal volumeGrapeUse;
    @XmlElement(name = "VolumeToAgingRaw", required = true)
    protected BigDecimal volumeToAgingRaw;
    @XmlElement(name = "VolumeFromAgingRaw", required = true)
    protected BigDecimal volumeFromAgingRaw;
    @XmlElement(name = "VolumeUsedgRaw", required = true)
    protected BigDecimal volumeUsedgRaw;
    @XmlElement(name = "TotalRaw", required = true)
    protected BigDecimal totalRaw;

    /**
     * Gets the value of the raw property.
     * 
     * @return
     *     possible object is
     *     {@link ProductInfoAsiiuV2 }
     *     
     */
    public ProductInfoAsiiuV2 getRaw() {
        return raw;
    }

    /**
     * Sets the value of the raw property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInfoAsiiuV2 }
     *     
     */
    public void setRaw(ProductInfoAsiiuV2 value) {
        this.raw = value;
    }

    /**
     * Gets the value of the volumeRest property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeRest() {
        return volumeRest;
    }

    /**
     * Sets the value of the volumeRest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeRest(BigDecimal value) {
        this.volumeRest = value;
    }

    /**
     * Gets the value of the volumeGrapeCollect property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeGrapeCollect() {
        return volumeGrapeCollect;
    }

    /**
     * Sets the value of the volumeGrapeCollect property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeGrapeCollect(BigDecimal value) {
        this.volumeGrapeCollect = value;
    }

    /**
     * Gets the value of the volumeGrapeUse property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeGrapeUse() {
        return volumeGrapeUse;
    }

    /**
     * Sets the value of the volumeGrapeUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeGrapeUse(BigDecimal value) {
        this.volumeGrapeUse = value;
    }

    /**
     * Gets the value of the volumeToAgingRaw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeToAgingRaw() {
        return volumeToAgingRaw;
    }

    /**
     * Sets the value of the volumeToAgingRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeToAgingRaw(BigDecimal value) {
        this.volumeToAgingRaw = value;
    }

    /**
     * Gets the value of the volumeFromAgingRaw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeFromAgingRaw() {
        return volumeFromAgingRaw;
    }

    /**
     * Sets the value of the volumeFromAgingRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeFromAgingRaw(BigDecimal value) {
        this.volumeFromAgingRaw = value;
    }

    /**
     * Gets the value of the volumeUsedgRaw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeUsedgRaw() {
        return volumeUsedgRaw;
    }

    /**
     * Sets the value of the volumeUsedgRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeUsedgRaw(BigDecimal value) {
        this.volumeUsedgRaw = value;
    }

    /**
     * Gets the value of the totalRaw property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalRaw() {
        return totalRaw;
    }

    /**
     * Sets the value of the totalRaw property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalRaw(BigDecimal value) {
        this.totalRaw = value;
    }

}
