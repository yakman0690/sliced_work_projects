package ru.fsrar.wegais.ttnsingle_v4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WbType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WbType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WBReturnToMe"/>
 *     &lt;enumeration value="WBInvoiceToMe"/>
 *     &lt;enumeration value="WBReturnFromMe"/>
 *     &lt;enumeration value="WBInvoiceFromMe"/>
 *     &lt;enumeration value="WBInternal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WbType")
@XmlEnum
public enum WbType {

    @XmlEnumValue("WBReturnToMe")
    WB_RETURN_TO_ME("WBReturnToMe"),
    @XmlEnumValue("WBInvoiceToMe")
    WB_INVOICE_TO_ME("WBInvoiceToMe"),
    @XmlEnumValue("WBReturnFromMe")
    WB_RETURN_FROM_ME("WBReturnFromMe"),
    @XmlEnumValue("WBInvoiceFromMe")
    WB_INVOICE_FROM_ME("WBInvoiceFromMe"),
    @XmlEnumValue("WBInternal")
    WB_INTERNAL("WBInternal");
    private final String value;

    WbType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WbType fromValue(String v) {
        for (WbType c: WbType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
