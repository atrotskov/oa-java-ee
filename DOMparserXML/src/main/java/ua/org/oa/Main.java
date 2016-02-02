package ua.org.oa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by jdev on 01.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        File inputFile = new File("ShoopRecord.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("goods");
            System.out.println("---------------------------------------");
            for (int i = 0; i < nodeList.getLength() ; i++) {
                Node nNode = nodeList.item(i);
                System.out.println("Current element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Goods id: " + eElement.getAttribute("id"));
                    System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Category: "
                            + eElement.getElementsByTagName("category").item(0).getTextContent());
                    System.out.println("Discription: "
                            + eElement.getElementsByTagName("discriotion").item(0).getTextContent());
                    System.out.println("-------------------------------------------------------------");
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
