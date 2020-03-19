package shkryl.task6.part1;

import shkryl.task6.Plant;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Stax {
    public static List<Plant> parseXmlFile(String fileName) {
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
                    } else if (startElement.getName().getLocalPart().equals("ZONE")) {
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
    }//end private static List<Plant> parseXMLfile(String fileName)
}
