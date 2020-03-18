package shkryl.task6.part1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import shkryl.task6.Plant;

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
        Logger logger = LoggerFactory.getLogger(Main.class);

        String fileName = "plant_catalog.xml";
        //StAX
        System.out.println("Выводим print_catalog.xml используя StAX");
        List<Plant> plantList = Stax.parseXmlFile(fileName);
        logger.info("<CATALOG>");
        for (Plant plant : plantList) {
            System.out.println(
                    plant.toString());
            //Добавляем вывод одновременно в лог
            logger.info("<PLANT>");
            logger.info("<COMMON>{}</COMMON>",plant.getCommon());
            logger.info("<BOTANICAL>{}</BOTANICAL>",plant.getBotanical());
            logger.info("<ZONE>{}</ZONE>",plant.getZone());
            logger.info("<LIGHT>{}</LIGHT>",plant.getLight());
            logger.info("<PRICE>{}</PRICE>",plant.getPrice());
            logger.info("<AVAILABILITY>{}</AVAILABILITY>",plant.getAvailability());
            logger.info("</PLANT>");
        }
        logger.info("</CATALOG>");

        System.out.println("---------------------------==");


        //DOM
        List<Plant> plantUseDomList;
        plantUseDomList = Dom.parseXmlFile(fileName);
        System.out.println("Выводим print_catalog.xml используя DOM");
        if (plantUseDomList!= null){
            for (Plant plant : plantUseDomList) {
                System.out.println(plant.toString());
            }
        } else{
            System.out.println("Вывод не возможен");
        }
    }//end -main






}
