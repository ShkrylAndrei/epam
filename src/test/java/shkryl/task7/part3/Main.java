package shkryl.task7.part3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String absulutePath = "C:\\myClasses\\TestClass";

        CustomClassLoader classLoader = new CustomClassLoader();
        //Class clazz = classLoader.findClass(absulutePath);
        Class clazz = classLoader.loadClass(absulutePath);
        Object obj = clazz.newInstance();
        System.out.println(obj);

    }
}
