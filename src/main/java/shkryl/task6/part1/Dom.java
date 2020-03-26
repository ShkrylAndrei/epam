package shkryl.task6.part1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import shkryl.task6.Plant;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с DOM
 */
public class Dom {
    /**
     * Парсит XML файл
     * @param file имя файла
     * @return коллекция объектов Plant
     */
    public static List<Plant> parseXmlFile(String file) {
        String filepath = file;
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("PLANT");

            List<Plant> plantUseDomList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                plantUseDomList.add(getPlant(nodeList.item(i)));
            }

            return plantUseDomList;

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Получение атрибутов
     * @param node Node
     * @return объект типа Plant
     */
    private static Plant getPlant(Node node) {
        Plant plant = new Plant();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            plant.setCommon(getTagValue("COMMON", element));
            plant.setBotanical(getTagValue("BOTANICAL", element));
            plant.setZone(getTagValue("ZONE", element));
            plant.setLight(getTagValue("LIGHT", element));
            plant.setPrice(getTagValue("PRICE", element));
            plant.setAvailability(getTagValue("AVAILABILITY", element));
        }
        return plant;
    }

    /**
     * Получение значение элемента по указанному тегу
     * @param tag имя тега
     * @param element элемент
     * @return строка содержащая значение переданного тега
     */
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
