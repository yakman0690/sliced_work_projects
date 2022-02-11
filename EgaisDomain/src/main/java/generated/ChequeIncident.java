//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 01:29:18 PM MSK 
//


package generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Bottle" type="{}bottleIncident" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inn" use="required" type="{}IN" />
 *       &lt;attribute name="kpp" type="{}KP" />
 *       &lt;attribute name="address" use="required" type="{}ADDRESS" />
 *       &lt;attribute name="name" use="required" type="{}NAME" />
 *       &lt;attribute name="kassa" use="required" type="{}NOEMPTY" />
 *       &lt;attribute name="shift" use="required" type="{}COUNT" />
 *       &lt;attribute name="number" use="required" type="{}COUNT" />
 *       &lt;attribute name="datetime" use="required" type="{}DT" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bottle"
})
@XmlRootElement(name = "ChequeIncident")
public class ChequeIncident {

    @XmlElement(name = "Bottle", required = true)
    protected List<BottleIncident> bottle;
    @XmlAttribute(name = "inn", required = true)
    protected String inn;
    @XmlAttribute(name = "kpp")
    protected String kpp;
    @XmlAttribute(name = "address", required = true)
    protected String address;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "kassa", required = true)
    protected String kassa;
    @XmlAttribute(name = "shift", required = true)
    protected BigInteger shift;
    @XmlAttribute(name = "number", required = true)
    protected BigInteger number;
    @XmlAttribute(name = "datetime", required = true)
    protected String datetime;

    /**
     * Gets the value of the bottle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bottle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBottle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BottleIncident }
     * 
     * 
     */
    public List<BottleIncident> getBottle() {
        if (bottle == null) {
            bottle = new ArrayList<BottleIncident>();
        }
        return this.bottle;
    }

    /**
     * Gets the value of the inn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInn() {
        return inn;
    }

    /**
     * Sets the value of the inn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInn(String value) {
        this.inn = value;
    }

    /**
     * Gets the value of the kpp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKpp() {
        return kpp;
    }

    /**
     * Sets the value of the kpp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKpp(String value) {
        this.kpp = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the kassa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKassa() {
        return kassa;
    }

    /**
     * Sets the value of the kassa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKassa(String value) {
        this.kassa = value;
    }

    /**
     * Gets the value of the shift property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getShift() {
        return shift;
    }

    /**
     * Sets the value of the shift property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setShift(BigInteger value) {
        this.shift = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    /**
     * Gets the value of the datetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * Sets the value of the datetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatetime(String value) {
        this.datetime = value;
    }

}