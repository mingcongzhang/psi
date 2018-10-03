/**
 * Runs verification tests to assure UserKey works correctly
 *
 * @author Greg Smith
 * @see UserKeyTestSuite.java
 */
package psi.componentwise.eval;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLIteration {

    private static void backgroundCheck(Node node) {
        System.out.println(node.getNodeName());
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                backgroundCheck(currentNode);
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File("C:\\Users\\zmc88\\Project\\psi exercise\\src\\main\\java\\psi\\componentwise\\eval\\sample.xml"));
        backgroundCheck(document.getDocumentElement());
    }

}
