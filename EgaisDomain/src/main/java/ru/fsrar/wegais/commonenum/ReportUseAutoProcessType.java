//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.05.25 at 03:09:56 PM MSK 
//


package ru.fsrar.wegais.commonenum;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportUseAutoProcessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReportUseAutoProcessType">
 *   &lt;restriction base="{http://fsrar.ru/WEGAIS/Common}NoEmptyString">
 *     &lt;enumeration value="Отчет об использовании ФСМ прошу автоматически сформировать на основе данных, зафиксированных заявителем в ЕГАИС расчетным путем."/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReportUseAutoProcessType")
@XmlEnum
public enum ReportUseAutoProcessType {

    @XmlEnumValue("\u041e\u0442\u0447\u0435\u0442 \u043e\u0431 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438 \u0424\u0421\u041c \u043f\u0440\u043e\u0448\u0443 \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0444\u043e\u0440\u043c\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043d\u0430 \u043e\u0441\u043d\u043e\u0432\u0435 \u0434\u0430\u043d\u043d\u044b\u0445, \u0437\u0430\u0444\u0438\u043a\u0441\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0445 \u0437\u0430\u044f\u0432\u0438\u0442\u0435\u043b\u0435\u043c \u0432 \u0415\u0413\u0410\u0418\u0421 \u0440\u0430\u0441\u0447\u0435\u0442\u043d\u044b\u043c \u043f\u0443\u0442\u0435\u043c.")
    ОТЧЕТ_ОБ_ИСПОЛЬЗОВАНИИ_ФСМ_ПРОШУ_АВТОМАТИЧЕСКИ_СФОРМИРОВАТЬ_НА_ОСНОВЕ_ДАННЫХ_ЗАФИКСИРОВАННЫХ_ЗАЯВИТЕЛЕМ_В_ЕГАИС_РАСЧЕТНЫМ_ПУТЕМ("\u041e\u0442\u0447\u0435\u0442 \u043e\u0431 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0438 \u0424\u0421\u041c \u043f\u0440\u043e\u0448\u0443 \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0441\u0444\u043e\u0440\u043c\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043d\u0430 \u043e\u0441\u043d\u043e\u0432\u0435 \u0434\u0430\u043d\u043d\u044b\u0445, \u0437\u0430\u0444\u0438\u043a\u0441\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0445 \u0437\u0430\u044f\u0432\u0438\u0442\u0435\u043b\u0435\u043c \u0432 \u0415\u0413\u0410\u0418\u0421 \u0440\u0430\u0441\u0447\u0435\u0442\u043d\u044b\u043c \u043f\u0443\u0442\u0435\u043c.");
    private final String value;

    ReportUseAutoProcessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReportUseAutoProcessType fromValue(String v) {
        for (ReportUseAutoProcessType c: ReportUseAutoProcessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}