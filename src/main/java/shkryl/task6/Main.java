package shkryl.task6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "plant_catalog.xml";
        //StAX
        List<Plant> plantList = parseXMLfile(fileName);

        for (Plant plant : plantList) {
            System.out.println(
                    plant.toString());
        }

        System.out.println("---------------------------");

        //Пока божественный метод умеет все потом разобью по классам
        //DOM
        String filepath = "plant_catalog.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
            // получаем узлы с именем Language
            // теперь XML полностью загружен в память
            // в виде объекта Document
            NodeList nodeList = document.getElementsByTagName("PLANT");

            // создадим из него список объектов Language
            List<Plant> plantUseDomList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                plantUseDomList.add(getPlant(nodeList.item(i)));
            }

            // печатаем в консоль информацию по каждому объекту Language
            for (Plant plant : plantUseDomList) {
                System.out.println(plant.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }




    }
    //Stax
    private static List<Plant> parseXMLfile(String fileName) {
        List<Plant> plantList = new ArrayList<>();
        Plant plant = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = null;
                try {
                    xmlEvent = reader.nextEvent();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }


                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("PLANT")) {
                        plant = new Plant();

                    } else if (startElement.getName().getLocalPart().equals("COMMON")) {
                        xmlEvent = reader.nextEvent();
                        plant.setCommon(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("BOTANICAL")) {
                        xmlEvent = reader.nextEvent();
                        plant.setBotanical(xmlEvent.asCharacters().getData());
                    }  else if (startElement.getName().getLocalPart().equals("ZONE")) {
                        xmlEvent = reader.nextEvent();
                        plant.setZone(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("LIGHT")) {
                        xmlEvent = reader.nextEvent();
                        plant.setLight(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("PRICE")) {
                        xmlEvent = reader.nextEvent();
                        plant.setPrice(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("AVAILABILITY")) {
                        xmlEvent = reader.nextEvent();
                        plant.setAvailability(xmlEvent.asCharacters().getData());
                    }

//
                }
                // если цикл дошел до закрывающего элемента Plant,
                // то добавляем считанного из файла объектаа в список
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("PLANT")) {
                        plantList.add(plant);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return plantList;
    }

    //DOM
    private static Plant getPlant(Node node) {
        Plant plant = new Plant();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            plant.setCommon(getTagValue("COMMON", element));
            //lang.setAge(Integer.parseInt(getTagValue("age", element)));
        }

        return plant;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
