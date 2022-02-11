//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.ticket;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OperationResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="OperationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OperationResult" type="{http://fsrar.ru/WEGAIS/Ticket}ConclusionType"/>
 *         &lt;element name="OperationComment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OperationDate" type="{http://fsrar.ru/WEGAIS/Common}DateWTime" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationResultType", propOrder = {

})
public class OperationResultType {

    @XmlElement(name = "OperationName", required = true)
    protected String operationName;
    @XmlElement(name = "OperationResult", required = true)
    @XmlSchemaType(name = "string")
    protected ConclusionType operationResult;
    @XmlElement(name = "OperationComment", required = true)
    protected String operationComment;
    @XmlElement(name = "OperationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operationDate;

    /**
     * Gets the value of the operationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Sets the value of the operationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationName(String value) {
        this.operationName = value;
    }

    /**
     * Gets the value of the operationResult property.
     * 
     * @return
     *     possible object is
     *     {@link ConclusionType }
     *     
     */
    public ConclusionType getOperationResult() {
        return operationResult;
    }

    /**
     * Sets the value of the operationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConclusionType }
     *     
     */
    public void setOperationResult(ConclusionType value) {
        this.operationResult = value;
    }

    /**
     * Gets the value of the operationComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationComment() {
        return operationComment;
    }

    /**
     * Sets the value of the operationComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationComment(String value) {
        this.operationComment = value;
    }

    /**
     * Gets the value of the operationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperationDate() {
        return operationDate;
    }

    /**
     * Sets the value of the operationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOperationDate(XMLGregorianCalendar value) {
        this.operationDate = value;
    }

}
