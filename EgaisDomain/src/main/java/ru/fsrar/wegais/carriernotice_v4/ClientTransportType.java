//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.carriernotice_v4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.fsrar.wegais.clientref_v2.OrgInfoRusV2;


/**
 * “ип документа
 * 
 * <p>Java class for ClientTransportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientTransportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Car" type="{http://fsrar.ru/WEGAIS/ClientRef_v2}OrgInfoRus_v2"/>
 *         &lt;element name="Railway" type="{http://fsrar.ru/WEGAIS/CarrierNotice_v4}RailwayType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientTransportType", propOrder = {
    "car",
    "railway"
})
public class ClientTransportType {

    @XmlElement(name = "Car")
    protected OrgInfoRusV2 car;
    @XmlElement(name = "Railway")
    protected RailwayType railway;

    /**
     * Gets the value of the car property.
     * 
     * @return
     *     possible object is
     *     {@link OrgInfoRusV2 }
     *     
     */
    public OrgInfoRusV2 getCar() {
        return car;
    }

    /**
     * Sets the value of the car property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrgInfoRusV2 }
     *     
     */
    public void setCar(OrgInfoRusV2 value) {
        this.car = value;
    }

    /**
     * Gets the value of the railway property.
     * 
     * @return
     *     possible object is
     *     {@link RailwayType }
     *     
     */
    public RailwayType getRailway() {
        return railway;
    }

    /**
     * Sets the value of the railway property.
     * 
     * @param value
     *     allowed object is
     *     {@link RailwayType }
     *     
     */
    public void setRailway(RailwayType value) {
        this.railway = value;
    }

}
