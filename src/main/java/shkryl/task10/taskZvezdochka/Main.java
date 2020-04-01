package shkryl.task10.taskZvezdochka;

import shkryl.task10.annotation.Entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CustomClassLoader classLoader = new CustomClassLoader();
//        List<Class> listClasses = new ArrayList();
//
//        try {
//            File root = new File(folderPath);
//            for (File file : root.listFiles()) {
//                if (file.getName().matches(".+\\.class")) {
//                    listClasses.add(classLoader.loadClass(Utils.getFileAbsolutePathWithoutExtension(file)));
//                }
//            }
//
//        } catch (Exception e) {
//            logger.error(e.toString());
//            System.out.println(e.toString());
//        }
//
//        boolean isExist = false;
//        for (Class clazz : listClasses) {
//            if (clazz.getName().equals(className)) {
//                //Object obj = clazz.newInstance();
//                Object obj = clazz.getInstance();
//                isExist = true;
//                System.out.println(obj);
//
//                if (!clazz.isAnnotationPresent(Entity.class)) {
//                    System.err.println(clazz.getName() + " has no Entity annotation");
//                    return false;
//                }
//                System.out.println("Класс " + clazz.getName() + " имеет аннотацияю Entity");
//            }
//        }
//        if (!isExist) {
//            System.out.println("Класс " + className + " не найден в директории " + folderPath);
//        }
    }
}
