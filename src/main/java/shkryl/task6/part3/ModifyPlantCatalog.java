package shkryl.task6.part3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import shkryl.task6.Plant;
import shkryl.task6.part1.Dom;
import shkryl.task6.part2.CheckValidateXml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class ModifyPlantCatalog {
    public static void modify(String file_name) {
        String nameXmlFileForCreate = file_name;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            // создаем пустой объект Document, в котором будем
            // создавать наш xml-файл
            Document doc = builder.newDocument();
            // создаем корневой элемент
            Element rootElement =
                    doc.createElementNS("", "CATALOG");




            // добавляем корневой элемент в объект Document
            doc.appendChild(rootElement);

            //Читаем plant_catalog.xml
            List<Plant> listPlant = Dom.parseXmlFile("plant_catalog.xml");
            //Обрабатываем listPlant и записываем все в новый файл
            for (Plant plant : listPlant){
               //Редактируем xml загруженный в listPlant
                if (!plant.getZone().equals("4")) {
                    rootElement.appendChild(getPlant(doc, plant.getCommon(), plant.getBotanical(), plant.getZone(),
                            plant.getLight(), plant.getPrice(), plant.getAvailability()));
                }
            }


            //создаем объект TransformerFactory для печати в консоль
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // для красивого вывода в консоль
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //печатаем в консоль или файл
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(nameXmlFileForCreate));

            //записываем данные
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    // метод для создания нового узла XML-файла
    private static Node getPlant(Document doc, String common, String botanical, String zone, String light, String price, String availability) {
        Element plant = doc.createElement("PLANT");

        plant.appendChild(getParam(doc, "COMMON", common));
        plant.appendChild(getParam(doc, "BOTANICAL", botanical));
        plant.appendChild(getParam(doc, "ZONE", zone));
        plant.appendChild(getParam(doc, "LIGHT", light));
        plant.appendChild(getParam(doc, "PRICE", price));
        plant.appendChild(getParam(doc, "AVAILABILITY", availability));

        return plant;
    }



    private static Node getParam(Document doc, String paramName, String value){
        Element node = doc.createElement(paramName);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
