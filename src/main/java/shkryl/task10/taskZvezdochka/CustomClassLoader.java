package shkryl.task10.taskZvezdochka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task10.taskZvezdochka.Utils;

public class CustomClassLoader extends ClassLoader {
    Logger logger;

    public CustomClassLoader() {
        logger = LoggerFactory.getLogger(CustomClassLoader.class);
    }

    //Переопределяем метод findClass, которому надо передать путь к файлу с расширением .class
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