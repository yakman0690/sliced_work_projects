//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.actttnsingle_v4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WbChangeOwnershipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WbChangeOwnershipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IsChange"/>
 *     &lt;enumeration value="NotChange"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WbChangeOwnershipType")
@XmlEnum
public enum WbChangeOwnershipType {

    @XmlEnumValue("IsChange")
    IS_CHANGE("IsChange"),
    @XmlEnumValue("NotChange")
    NOT_CHANGE("NotChange");
    private final String value;

    WbChangeOwnershipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WbChangeOwnershipType fromValue(String v) {
        for (WbChangeOwnershipType c: WbChangeOwnershipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
