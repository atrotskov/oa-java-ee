package ua.org.oa.util;

import ua.org.oa.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by jdev on 07.02.2016.
 */
public class jaxbUtil {
    public static void doMurshaller(Shop shop, String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File XMLfile = new File(filePath);
        jaxbMarshaller.marshal(shop, XMLfile);
        jaxbMarshaller.marshal(shop, System.out);
    }

    public static Shop DoUnmarshaller(String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Shop.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File XMLfile = new File(filePath);
        return (Shop) jaxbUnmarshaller.unmarshal(XMLfile);
    }

}
