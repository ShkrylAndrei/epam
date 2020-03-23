package shkryl.task7.part3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task7.util.Utils;

/**
 * Класс наследуется от ClassLoader и содержит переопределенный метод findClass
 */
public class CustomClassLoader extends ClassLoader {
    Logger logger;

    public CustomClassLoader() {
        logger = LoggerFactory.getLogger(CustomClassLoader.class);
    }

    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class

    /**
     * Считывает класс по его абсолютному пути absoluteFileName и генерирует Class объект на основе данного класса
     *
     * @param absoluteFileName абсолютный путь к файлу
     * @return возвращает Class объект
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String absoluteFileName) throws ClassNotFoundException {
        byte[] bytes = Utils.readFile(absoluteFileName);
        if (bytes != null) {

            return defineClass(Utils.getFileNameFromAbsoluteFileName(absoluteFileName), bytes, 0, bytes.length);
        }

        logger.error("Проблемы с байт кодом");
        throw new ClassNotFoundException("Проблемы с байт кодом");
    }


}