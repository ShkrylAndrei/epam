package shkryl.task7.part3;

import shkryl.task7.util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String className = "TestClass";
        String folderPath = "C:\\myClasses\\";


        CustomClassLoader classLoader = new CustomClassLoader();
        List<Class> listClasses = new ArrayList();
        try {
            File root = new File(folderPath);
            for(File file : root.listFiles()){
                if(file.getName().matches(".+\\.class")){
                    listClasses.add(classLoader.loadClass(Utils.getFileAbsolutePathWithoutExtension(file)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean isExist = false;
        for(Class clazz : listClasses){
            if(clazz.getName().equals(className)){
                Object obj = clazz.newInstance();
                isExist = true;
                System.out.println(obj);
            }
        }
        if(!isExist){
            System.out.println("Класс "+className+" не найден в директории "+folderPath);
        }
    }
}
