package shkryl.task7.part3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task7.util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger logger;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        logger = LoggerFactory.getLogger(Main.class);

        String className = "TestClass";
        String folderPath = "C:\\myClasses\\";


        CustomClassLoader classLoader = new CustomClassLoader();
        List<Class> listClasses = new ArrayList();
        try {
            File root = new File(folderPath);
            for (File file : root.listFiles()) {
                if (file.getName().matches(".+\\.class")) {
                    listClasses.add(classLoader.loadClass(Utils.getFileAbsolutePathWithoutExtension(file)));
                }
            }

        } catch (Exception e) {
            logger.error(e.toString());
            System.out.println(e.toString());
        }

        boolean isExist = false;
        for (Class clazz : listClasses) {
            if (clazz.getName().equals(className)) {
                Object obj = clazz.newInstance();
                isExist = true;
                System.out.println(obj);
            }
        }
        if (!isExist) {
            System.out.println("Класс " + className + " не найден в директории " + folderPath);
        }
    }
}
