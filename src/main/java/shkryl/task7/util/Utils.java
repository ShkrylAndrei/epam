package shkryl.task7.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task7.part3.CustomClassLoader;

import java.io.*;

import static org.slf4j.LoggerFactory.getLogger;

//Содержит вспомогательные методы
public final class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);;

    private Utils() {

    }

    //Возращаем расширение файла
//    public static String getFileExtension(File file) {
//        String fileName = file.getName();
//        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
//            return fileName.substring(fileName.lastIndexOf(".") + 1);
//        } else return "";
//    }

    //Возращает имя файл из абсолютного пути
    public static String getFileNameFromAbsoluteFileName(String path) {
        File f = new File(path);
        return f.getName();
    }

    //Возращает имя файла без расширения из абсолютного пути или пустую строку если путь неккореткный
    public static String getFileAbsolutePathWithoutExtension(File file) {
        String filePath = file.getAbsolutePath();
        if (filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0) {
            return filePath.substring(0, filePath.lastIndexOf("."));
        } else return "";
    }

    //Читаем файл скомпилированного класса и возращаем в виде массива байт
    //или null если считать не удалось
    public static byte[] readFile(String fileName) throws ClassNotFoundException {

        File f = new File(fileName + ".class");
        if (!f.isFile()) {
            throw new ClassNotFoundException("Нет такого класса " + fileName);
        }
        InputStream ins = null;

        //С помощью потока считываем файл в массив байт
        try {
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[] b = new byte[(int) f.length()];
            ins.read(b);
            return b;
        } catch (IOException e) {
            logger.error(e.toString());
            System.out.println(e.toString());
        } finally {
            try {
                ins.close();
            } catch (Exception e) {
                logger.error(e.toString());
                System.out.println(e.toString());
            }
            ;
        }
        return null;
    }
}
