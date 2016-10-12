package gov.nationalweather;

import gov.nationalweather.NdfdXMLBindingStub;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by netherskub on 10/10/16.
 */
public class NdfdXMLBindingStudTest {

    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53711");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));
        assertEquals("Results did not equal expected value", "43.0798,-89.3875", dwml.getLatLonList());
    }
}
