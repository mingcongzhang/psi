package psi.componentwise.eval;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TestXMLIteration {

    @Test(expected = SAXException.class)
    public void testXMLIterationSAXException() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        XMLIteration.backgroundCheck(docBuilder.parse("/").getDocumentElement());
    }

    @Test(expected = SAXException.class)
    public void testXMLIterationMissingEndTag() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("C:\\Users\\zmc88\\Project\\psi exercise\\src\\main\\java\\psi\\componentwise\\eval\\badSample.xml"));
        XMLIteration.backgroundCheck(document.getDocumentElement());
    }
}
