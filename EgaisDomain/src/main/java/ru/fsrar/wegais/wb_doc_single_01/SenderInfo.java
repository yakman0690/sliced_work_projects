package ru.fsrar.wegais.wb_doc_single_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация об отправителе
 * 
 * <p>Java class for SenderInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SenderInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="FSRAR_ID" type="{http://fsrar.ru/WEGAIS/Common}FSRARIDType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SenderInfo", propOrder = {

})
public class SenderInfo {

    @XmlElement(name = "FSRAR_ID", required = true)
    protected String fsrarid;

    /**
     * Gets the value of the fsrarid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFSRARID() {
        return fsrarid;
    }

    /**
     * Sets the value of the fsrarid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFSRARID(String value) {
        this.fsrarid = value;
    }

}
