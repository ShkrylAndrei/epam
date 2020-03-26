package shkryl.task6.part2;


import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Класс на валидацию XML файла
 */
public class CheckValidateXml {
    /**
     * Проверка XML файла
     * @param xsd xsd схема
     * @param xml xml файл
     * @return строка валидный или не валидный файл
     */
    public static String check(String xsd, String xml) {
        boolean answer = validateXMLSchema(xsd, xml);
        if (answer == true) {
            return "Файл " + xml + " успешно прошел валидацию";
        } else {
            return "Файл " + xml + " не прошел валидацию";
        }
    }

    /**
     * Валидация файла
     * @param xsdPath xsd файл
     * @param xmlPath xml файл
     * @return
     */
    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            // Получить фабрику для схемы
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            // Загрузить схему из XSD
            Schema schema = factory.newSchema(new File(xsdPath));
            // Создать валидатор (проверялбщик)
            Validator validator = schema.newValidator();
            // Запусить проверку - если будет исключение, значит есть ошибки.
            // Если нет - все заполнено правильно
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}