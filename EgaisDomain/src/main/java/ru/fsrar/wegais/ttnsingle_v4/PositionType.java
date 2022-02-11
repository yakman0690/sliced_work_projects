package ru.fsrar.wegais.ttnsingle_v4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.fsrar.wegais.commonv3.Boxtype;
import ru.fsrar.wegais.commonv3.InformF2TypeItemBC;
import ru.fsrar.wegais.productref_v2.ProductInfoV2;


/**
 * Позиция
 * 
 * <p>Java class for PositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PositionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Product" type="{http://fsrar.ru/WEGAIS/ProductRef_v2}ProductInfo_v2"/>
 *         &lt;element name="Pack_ID" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType"/>
 *         &lt;element name="alcPercent" type="{http://fsrar.ru/WEGAIS/Common}AlcPercentType" minOccurs="0"/>
 *         &lt;element name="alcPercentMin" type="{http://fsrar.ru/WEGAIS/Common}AlcPercentType" minOccurs="0"/>
 *         &lt;element name="alcPercentMax" type="{http://fsrar.ru/WEGAIS/Common}AlcPercentType" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType"/>
 *         &lt;element name="Party" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="Identity" type="{http://fsrar.ru/WEGAIS/Common}IdentityType"/>
 *         &lt;element name="EXCISE_NUMBER" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EXCISE_DATE" type="{http://fsrar.ru/WEGAIS/Common}DateWTime" minOccurs="0"/>
 *         &lt;element name="EXCISE_SUM" type="{http://fsrar.ru/WEGAIS/Common}NoNegativeDecimalType" minOccurs="0"/>
 *         &lt;element name="EXCISE_BS" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType" minOccurs="0"/>
 *         &lt;element name="EAN13" type="{http://fsrar.ru/WEGAIS/Common}EANType" minOccurs="0"/>
 *         &lt;element name="FARegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50"/>
 *         &lt;element name="InformF2" type="{http://fsrar.ru/WEGAIS/CommonV3}InformF2TypeItemBC"/>
 *         &lt;element name="boxInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="boxtree" type="{http://fsrar.ru/WEGAIS/CommonV3}boxtype" maxOccurs="unbounded"/>
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
@XmlType(name = "PositionType", propOrder = {

})
public class PositionType {

    @XmlElement(name = "Product", required = true)
    protected ProductInfoV2 product;
    @XmlElement(name = "Pack_ID")
    protected String packID;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;
    protected BigDecimal alcPercent;
    protected BigDecimal alcPercentMin;
    protected BigDecimal alcPercentMax;
    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "Party")
    protected String party;
    @XmlElement(name = "Identity", required = true)
    protected String identity;
    @XmlElement(name = "EXCISE_NUMBER")
    protected String excisenumber;
    @XmlElement(name = "EXCISE_DATE")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar excisedate;
    @XmlElement(name = "EXCISE_SUM")
    protected BigDecimal excisesum;
    @XmlElement(name = "EXCISE_BS")
    protected BigDecimal excisebs;
    @XmlElement(name = "EAN13")
    protected String ean13;
    @XmlElement(name = "FARegId", required = true)
    protected String faRegId;
    @XmlElement(name = "InformF2", required = true)
    protected InformF2TypeItemBC informF2;
    protected PositionType.BoxInfo boxInfo;
@XmlTransient
    private List<String> scannedMarks = new ArrayList<>();

    public List<String> getScannedMarks() {
        if(scannedMarks == null)
            scannedMarks = new ArrayList<>();
        return scannedMarks;
    }

    public void setScannedMarks(List<String> scannedMarks) {
        this.scannedMarks = scannedMarks;
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
     * Gets the value of the packID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackID() {
        return packID;
    }

    /**
     * Sets the value of the packID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackID(String value) {
        this.packID = value;
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
     * Gets the value of the alcPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAlcPercent() {
        return alcPercent;
    }

    /**
     * Sets the value of the alcPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAlcPercent(BigDecimal value) {
        this.alcPercent = value;
    }

    /**
     * Gets the value of the alcPercentMin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAlcPercentMin() {
        return alcPercentMin;
    }

    /**
     * Sets the value of the alcPercentMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAlcPercentMin(BigDecimal value) {
        this.alcPercentMin = value;
    }

    /**
     * Gets the value of the alcPercentMax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAlcPercentMax() {
        return alcPercentMax;
    }

    /**
     * Sets the value of the alcPercentMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAlcPercentMax(BigDecimal value) {
        this.alcPercentMax = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParty(String value) {
        this.party = value;
    }

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
     * Gets the value of the excisenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXCISENUMBER() {
        return excisenumber;
    }

    /**
     * Sets the value of the excisenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXCISENUMBER(String value) {
        this.excisenumber = value;
    }

    /**
     * Gets the value of the excisedate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEXCISEDATE() {
        return excisedate;
    }

    /**
     * Sets the value of the excisedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEXCISEDATE(XMLGregorianCalendar value) {
        this.excisedate = value;
    }

    /**
     * Gets the value of the excisesum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEXCISESUM() {
        return excisesum;
    }

    /**
     * Sets the value of the excisesum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEXCISESUM(BigDecimal value) {
        this.excisesum = value;
    }

    /**
     * Gets the value of the excisebs property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEXCISEBS() {
        return excisebs;
    }

    /**
     * Sets the value of the excisebs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEXCISEBS(BigDecimal value) {
        this.excisebs = value;
    }

    /**
     * Gets the value of the ean13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEAN13() {
        return ean13;
    }

    /**
     * Sets the value of the ean13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEAN13(String value) {
        this.ean13 = value;
    }

    /**
     * Gets the value of the faRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFARegId() {
        return faRegId;
    }

    /**
     * Sets the value of the faRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFARegId(String value) {
        this.faRegId = value;
    }

    /**
     * Gets the value of the informF2 property.
     * 
     * @return
     *     possible object is
     *     {@link InformF2TypeItemBC }
     *     
     */
    public InformF2TypeItemBC getInformF2() {
        return informF2;
    }

    /**
     * Sets the value of the informF2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link InformF2TypeItemBC }
     *     
     */
    public void setInformF2(InformF2TypeItemBC value) {
        this.informF2 = value;
    }

    /**
     * Gets the value of the boxInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PositionType.BoxInfo }
     *     
     */
    public PositionType.BoxInfo getBoxInfo() {
        return boxInfo;
    }

    /**
     * Sets the value of the boxInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionType.BoxInfo }
     *     
     */
    public void setBoxInfo(PositionType.BoxInfo value) {
        this.boxInfo = value;
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
     *         &lt;element name="boxtree" type="{http://fsrar.ru/WEGAIS/CommonV3}boxtype" maxOccurs="unbounded"/>
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
        "boxtree"
    })
    public static class BoxInfo {

        @XmlElement(required = true)
        protected List<Boxtype> boxtree;

        /**
         * Gets the value of the boxtree property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the boxtree property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBoxtree().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Boxtype }
         * 
         * 
         */
        public List<Boxtype> getBoxtree() {
            if (boxtree == null) {
                boxtree = new ArrayList<Boxtype>();
            }
            return this.boxtree;
        }

    }

}
