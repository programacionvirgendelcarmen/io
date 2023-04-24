package teoria.xml;

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
import java.util.ArrayList;
import java.util.List;

public class LeerXML {
    public static void main(String[] args) {
        List<Site> sites = new ArrayList<>();
        File inputFile = new File("FILES_TEORIA/cities.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
          //  System.out.println(
           //         "Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("site");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String city = eElement
                            .getElementsByTagName("city")
                            .item(0)
                            .getTextContent();
                    String country = eElement
                            .getElementsByTagName("country")
                            .item(0)
                            .getTextContent();
                    String latitude = eElement
                            .getElementsByTagName("latitude")
                            .item(0)
                            .getTextContent();
                    String longitude = eElement
                            .getElementsByTagName("longitude")
                            .item(0)
                            .getTextContent();
                  //  System.out.println(city + "-" + country + ":" + latitude + ":" + longitude);
                    sites.add(new Site(city, country, Float.parseFloat(latitude),
                            Float.parseFloat(longitude)));
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        for (Site site : sites) {
            System.out.println(site);
        }
    }
}
