package shkryl.task6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModifyPlant {
    public static void main(String[] args) {
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



    private static Plant getPlant(Node node) {
        Plant plant = new Plant();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            plant.setCommon(getTagValue("COMMON", element));
            plant.setBotanical(getTagValue("BOTANICAL", element));
            plant.setZone(getTagValue("ZONE", element));
            //Изменение
           // plant.setZone("new value");
//            if ((((Element) node).getAttribute("id")).equals("5")) {
//                plant.setZone("new value");
//            }




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
