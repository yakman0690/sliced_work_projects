package ru.fsrar.wegais.ttnsingle_v4;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.fsrar.wegais.ttnsingle_v4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.fsrar.wegais.ttnsingle_v4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WayBillTypeV4 }
     * 
     */
    public WayBillTypeV4 createWayBillTypeV4() {
        return new WayBillTypeV4();
    }

    /**
     * Create an instance of {@link PositionType }
     * 
     */
    public PositionType createPositionType() {
        return new PositionType();
    }

    /**
     * Create an instance of {@link TransportType }
     * 
     */
    public TransportType createTransportType() {
        return new TransportType();
    }

    /**
     * Create an instance of {@link WayBillTypeV4 .Header }
     * 
     */
    public WayBillTypeV4 .Header createWayBillTypeV4Header() {
        return new WayBillTypeV4 .Header();
    }

    /**
     * Create an instance of {@link WayBillTypeV4 .Content }
     * 
     */
    public WayBillTypeV4 .Content createWayBillTypeV4Content() {
        return new WayBillTypeV4 .Content();
    }

    /**
     * Create an instance of {@link PositionType.BoxInfo }
     * 
     */
    public PositionType.BoxInfo createPositionTypeBoxInfo() {
        return new PositionType.BoxInfo();
    }

}
