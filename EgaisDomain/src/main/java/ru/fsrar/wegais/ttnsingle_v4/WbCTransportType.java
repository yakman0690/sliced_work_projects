package ru.fsrar.wegais.ttnsingle_v4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WbCTransportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WbCTransportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="car"/>
 *     &lt;enumeration value="ship"/>
 *     &lt;enumeration value="railway"/>
 *     &lt;enumeration value="aircraft"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WbCTransportType")
@XmlEnum
public enum WbCTransportType {

    @XmlEnumValue("car")
    CAR("car"),
    @XmlEnumValue("ship")
    SHIP("ship"),
    @XmlEnumValue("railway")
    RAILWAY("railway"),
    @XmlEnumValue("aircraft")
    AIRCRAFT("aircraft"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    WbCTransportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WbCTransportType fromValue(String v) {
        for (WbCTransportType c: WbCTransportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
