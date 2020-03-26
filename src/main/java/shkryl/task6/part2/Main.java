package shkryl.task6.part2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
        String nameXmlFileForCreate = "book_create_by_Java.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            // создаем пустой объект Document, в котором будем
            // создавать наш xml-файл
            Document doc = builder.newDocument();
            // создаем корневой элемент
            Element rootElement =
                    doc.createElementNS("", "books");

            rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "book.xsd");

            // добавляем корневой элемент в объект Document
            doc.appendChild(rootElement);

            // добавляем первый дочерний элемент к корневому
            Node book1 = rootElement.appendChild(getBook(doc, "1", "Andrei", "Shkryl", "Aleksandrovich",
                    "300", "Fairy tail", "Fakel"));

            Node book2 = rootElement.appendChild(getBook(doc, "2", "Andrei", "Shkryl", "Aleksandrovich",
                    "350", "Fairy tail2", "Fakel2"));

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

        System.out.println(CheckValidateXml.check("book.xsd", nameXmlFileForCreate));
    }

    // метод для создания нового узла XML-файла
    private static Node getBook(Document doc, String id, String firstname, String lastName, String secondname, String pagecount, String namebook, String publisher) {
        Element book = doc.createElement("book");
        // устанавливаем атрибут id
        book.setAttribute("bookid", id);

        book.appendChild(getAuthor(doc, firstname, lastName, secondname));

        book.appendChild(getParam(doc, "pagecount", pagecount));
        book.appendChild(getParam(doc, "namebook", namebook));
        book.appendChild(getParam(doc, "publisher", publisher));

        return book;
    }

    private static Node getAuthor(Document doc, String firstname, String lastname, String secondname) {
        Element author = doc.createElement("author");

        // создаем элемент name
        author.appendChild(getParam(doc, "firstname", firstname));
        author.appendChild(getParam(doc, "lastname", lastname));
        author.appendChild(getParam(doc, "secondname", secondname));

        return author;
    }


    private static Node getParam(Document doc, String paramName, String value) {
        Element node = doc.createElement(paramName);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
