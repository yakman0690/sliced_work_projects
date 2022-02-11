//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.13 at 12:56:37 PM MSK 
//


package ru.fsrar.wegais.repproducedproduct_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OperType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OperProduction"/>
 *     &lt;enumeration value="OperConversion"/>
 *     &lt;enumeration value="OperMaterials"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OperType")
@XmlEnum
public enum OperType {

    @XmlEnumValue("OperProduction")
    OPER_PRODUCTION("OperProduction"),
    @XmlEnumValue("OperConversion")
    OPER_CONVERSION("OperConversion"),
    @XmlEnumValue("OperMaterials")
    OPER_MATERIALS("OperMaterials");
    private final String value;

    OperType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperType fromValue(String v) {
        for (OperType c: OperType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
