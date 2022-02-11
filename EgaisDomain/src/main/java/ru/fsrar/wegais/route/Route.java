package ru.fsrar.wegais.route;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Транспортная Накладная
 * 
 * <p>Java class for Route complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Route">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NUMBER" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString"/>
 *         &lt;element name="Date" type="{http://fsrar.ru/WEGAIS/Common}DateNoTime"/>
 *         &lt;element name="Ownership">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WBRegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString"/>
 *         &lt;element name="ParentRoutes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RouteId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TRAN_TYPE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="410"/>
 *               &lt;enumeration value="411"/>
 *               &lt;enumeration value="412"/>
 *               &lt;enumeration value="413"/>
 *               &lt;enumeration value="419"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRAN_COMPANY" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="TRAN_CAR" type="{http://fsrar.ru/WEGAIS/Route}Field255"/>
 *         &lt;element name="TRAN_TRAILER" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="TRAN_CUSTOMER" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="TRAN_DRIVER" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="TRAN_LOADPOINT" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString"/>
 *         &lt;element name="TRAN_UNLOADPOINT" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString"/>
 *         &lt;element name="TRAN_REDIRECT" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="TRAN_FORWARDER" type="{http://fsrar.ru/WEGAIS/Route}Field255" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://fsrar.ru/WEGAIS/Common}PositiveDecimalType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Route", propOrder = {
    "number",
    "date",
    "ownership",
    "wbRegId",
    "parentRoutes",
    "trantype",
    "trancompany",
    "trancar",
    "trantrailer",
    "trancustomer",
    "trandriver",
    "tranloadpoint",
    "tranunloadpoint",
    "tranredirect",
    "tranforwarder",
    "quantity"
})
public class Route {

    @XmlElement(name = "NUMBER", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Ownership", required = true)
    protected String ownership;
    @XmlElement(name = "WBRegId", required = true)
    protected String wbRegId;
    @XmlElement(name = "ParentRoutes", required = true)
    protected Route.ParentRoutes parentRoutes;
    @XmlElement(name = "TRAN_TYPE", required = true)
    protected String trantype;
    @XmlElement(name = "TRAN_COMPANY")
    protected String trancompany;
    @XmlElement(name = "TRAN_CAR", required = true)
    protected String trancar;
    @XmlElement(name = "TRAN_TRAILER")
    protected String trantrailer;
    @XmlElement(name = "TRAN_CUSTOMER")
    protected String trancustomer;
    @XmlElement(name = "TRAN_DRIVER")
    protected String trandriver;
    @XmlElement(name = "TRAN_LOADPOINT", required = true)
    protected String tranloadpoint;
    @XmlElement(name = "TRAN_UNLOADPOINT", required = true)
    protected String tranunloadpoint;
    @XmlElement(name = "TRAN_REDIRECT")
    protected String tranredirect;
    @XmlElement(name = "TRAN_FORWARDER")
    protected String tranforwarder;
    @XmlElement(name = "Quantity", required = true)
    protected BigDecimal quantity;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMBER() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMBER(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the ownership property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * Sets the value of the ownership property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnership(String value) {
        this.ownership = value;
    }

    /**
     * Gets the value of the wbRegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWBRegId() {
        return wbRegId;
    }

    /**
     * Sets the value of the wbRegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWBRegId(String value) {
        this.wbRegId = value;
    }

    /**
     * Gets the value of the parentRoutes property.
     * 
     * @return
     *     possible object is
     *     {@link Route.ParentRoutes }
     *     
     */
    public Route.ParentRoutes getParentRoutes() {
        return parentRoutes;
    }

    /**
     * Sets the value of the parentRoutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Route.ParentRoutes }
     *     
     */
    public void setParentRoutes(Route.ParentRoutes value) {
        this.parentRoutes = value;
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
     * Gets the value of the trancar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANCAR() {
        return trancar;
    }

    /**
     * Sets the value of the trancar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANCAR(String value) {
        this.trancar = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="RouteId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" maxOccurs="unbounded"/>
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
        "routeId"
    })
    public static class ParentRoutes {

        @XmlElement(name = "RouteId", required = true)
        protected List<String> routeId;

        /**
         * Gets the value of the routeId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the routeId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRouteId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRouteId() {
            if (routeId == null) {
                routeId = new ArrayList<String>();
            }
            return this.routeId;
        }

    }

}
