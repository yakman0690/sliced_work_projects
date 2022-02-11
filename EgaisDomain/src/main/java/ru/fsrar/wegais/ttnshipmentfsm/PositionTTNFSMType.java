package ru.fsrar.wegais.ttnshipmentfsm;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Позиция
 * 
 * <p>Java class for PositionTTNFSMType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PositionTTNFSMType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="SampleFSM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MarkType" type="{http://fsrar.ru/WEGAIS/Common}MarkGZTypeString"/>
 *         &lt;element name="RollNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="RangeNumberInRoll" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Rank" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}RankType"/>
 *         &lt;element name="Start" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}MarkNumberType"/>
 *         &lt;element name="Last" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}MarkNumberType"/>
 *         &lt;element name="QuantityRange" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PositionTTNFSMType", propOrder = {

})
public class PositionTTNFSMType {

    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "SampleFSM", required = true)
    protected String sampleFSM;
    @XmlElement(name = "MarkType", required = true)
    protected String markType;
    @XmlElement(name = "RollNumber", required = true)
    protected BigInteger rollNumber;
    @XmlElement(name = "RangeNumberInRoll", required = true)
    protected BigInteger rangeNumberInRoll;
    @XmlElement(name = "Rank", required = true)
    protected String rank;
    @XmlElement(name = "Start", required = true)
    protected String start;
    @XmlElement(name = "Last", required = true)
    protected String last;
    @XmlElement(name = "QuantityRange", required = true)
    protected BigInteger quantityRange;

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
     * Gets the value of the sampleFSM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSampleFSM() {
        return sampleFSM;
    }

    /**
     * Sets the value of the sampleFSM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSampleFSM(String value) {
        this.sampleFSM = value;
    }

    /**
     * Gets the value of the markType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarkType() {
        return markType;
    }

    /**
     * Sets the value of the markType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarkType(String value) {
        this.markType = value;
    }

    /**
     * Gets the value of the rollNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRollNumber() {
        return rollNumber;
    }

    /**
     * Sets the value of the rollNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRollNumber(BigInteger value) {
        this.rollNumber = value;
    }

    /**
     * Gets the value of the rangeNumberInRoll property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRangeNumberInRoll() {
        return rangeNumberInRoll;
    }

    /**
     * Sets the value of the rangeNumberInRoll property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRangeNumberInRoll(BigInteger value) {
        this.rangeNumberInRoll = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRank(String value) {
        this.rank = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStart(String value) {
        this.start = value;
    }

    /**
     * Gets the value of the last property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLast() {
        return last;
    }

    /**
     * Sets the value of the last property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLast(String value) {
        this.last = value;
    }

    /**
     * Gets the value of the quantityRange property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantityRange() {
        return quantityRange;
    }

    /**
     * Sets the value of the quantityRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantityRange(BigInteger value) {
        this.quantityRange = value;
    }

}
