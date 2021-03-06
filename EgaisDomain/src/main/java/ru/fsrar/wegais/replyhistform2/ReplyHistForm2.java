//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.replyhistform2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ответ на запрос о движении по форме Б
 * 
 * <p>Java class for ReplyHistForm2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReplyHistForm2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="InformF2RegId" type="{http://fsrar.ru/WEGAIS/Common}NoEmptyString50" minOccurs="0"/>
 *         &lt;element name="HistForm2Date" type="{http://fsrar.ru/WEGAIS/Common}DateWTime"/>
 *         &lt;element name="HistoryF2">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OperationB" type="{http://fsrar.ru/WEGAIS/ReplyHistForm2}OperationBType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "ReplyHistForm2", propOrder = {

})
public class ReplyHistForm2 {

    @XmlElement(name = "InformF2RegId")
    protected String informF2RegId;
    @XmlElement(name = "HistForm2Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar histForm2Date;
    @XmlElement(name = "HistoryF2", required = true)
    protected ReplyHistForm2 .HistoryF2 historyF2;

    /**
     * Gets the value of the informF2RegId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformF2RegId() {
        return informF2RegId;
    }

    /**
     * Sets the value of the informF2RegId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformF2RegId(String value) {
        this.informF2RegId = value;
    }

    /**
     * Gets the value of the histForm2Date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHistForm2Date() {
        return histForm2Date;
    }

    /**
     * Sets the value of the histForm2Date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHistForm2Date(XMLGregorianCalendar value) {
        this.histForm2Date = value;
    }

    /**
     * Gets the value of the historyF2 property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyHistForm2 .HistoryF2 }
     *     
     */
    public ReplyHistForm2 .HistoryF2 getHistoryF2() {
        return historyF2;
    }

    /**
     * Sets the value of the historyF2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyHistForm2 .HistoryF2 }
     *     
     */
    public void setHistoryF2(ReplyHistForm2 .HistoryF2 value) {
        this.historyF2 = value;
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
     *         &lt;element name="OperationB" type="{http://fsrar.ru/WEGAIS/ReplyHistForm2}OperationBType" maxOccurs="unbounded" minOccurs="0"/>
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
        "operationB"
    })
    public static class HistoryF2 {

        @XmlElement(name = "OperationB")
        protected List<OperationBType> operationB;

        /**
         * Gets the value of the operationB property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operationB property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperationB().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OperationBType }
         * 
         * 
         */
        public List<OperationBType> getOperationB() {
            if (operationB == null) {
                operationB = new ArrayList<OperationBType>();
            }
            return this.operationB;
        }

    }

}
