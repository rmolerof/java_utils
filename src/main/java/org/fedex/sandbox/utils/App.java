package org.fedex.sandbox.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException
    {
        JAXBContext jc = JAXBContext.newInstance(Tests.class);
        
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src\\main\\resources\\input.xml");
        Tests tests = (Tests) unmarshaller.unmarshal(xml);
        System.out.println(tests.toString());
        
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tests, System.out);
    }
}
