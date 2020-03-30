package shkryl.task10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {


    public static Object initFieldsByAnnotaionValue(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object object = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Value.class)) {
                Object value = getValueFromField(field);
                field.set(object, value);
            }else{
                Method method = getAnnotatedSetterForField(field, clazz);
                Object value = getValueFromMethod(method);
                field.set(object, value);
            }
        }
        return object;
    }

    private static Object getValueFromField(Field field){
        Value annotation = field.getAnnotation(Value.class);
        Class<?> checkedType = field.getType();
        return getValue(checkedType, annotation);
    }

    private static Object getValueFromMethod(Method method){
        Value annotation = method.getAnnotation(Value.class);
        Parameter setterParameter = method.getParameters()[0];
        Class<?> checkedType = setterParameter.getType();
        return getValue(checkedType, annotation);
    }

    private static Object getValue(Class<?> clazz, Value annotation){
        List<String> result = null;
        if(!annotation.pathToFile().isEmpty()){
            String filePath = annotation.pathToFile();
            //????? обработать исключения
            try {
                result = parseFile(readFile(filePath));

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(clazz==String.class) {
            if(result!=null){
                return result.get(1);
            }
            return annotation.stringValue();
        }else if(clazz==int.class){
            if(result!=null){
                return Integer.parseInt(result.get(0));
            }
            return annotation.intValue();
        }

        return null;
    }
    //???????????????????? Вынести в отдельный класс чтение файла
    public static List<String> readFile(String filePath) throws IOException {
        List<String> fileString = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(filePath));
        String str;
        while ((str=reader.readLine())!=null){
            fileString.add(str);
        }
        return fileString;
    }

    public static List<String> parseFile(List<String> lines){
        List<String> result = new ArrayList();
        String age = lines.get(0).split("=")[1];
        String name = lines.get(1).split("=")[1];
        result.add(age);
        result.add(name);
        return result;
    }



    public static boolean checkEntityAnnotation(Class<?> clazz) {

        if(!clazz.isAnnotationPresent(Entity.class)){
            System.err.println(clazz.getName()+" has no Entity annotation");
            return false;
        }

        System.out.println("Класс " + clazz.getName()+" имеет аннотацияю Entity");
        return true;

    }


    public static boolean checkNoValueAnnotationException(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            if(!field.isAnnotationPresent(Value.class)) {
                if(getAnnotatedSetterForField(field, clazz)==null){
                    throw new NoValueAnnotationException("Поле "+field.getName()+" не имеет аннотации Value");
                }
            }
        }
        System.out.println("Все поля класса "+clazz.getName()+" имеют аннотацию Value");
        return true;
    }

    public static boolean checkIllegalStateException(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields){
            if(field.isAnnotationPresent(Value.class)) {
                throw new IllegalStateException("Поле "+field.getName()+" не должно иметь аннотации Value, так как класс не является сущностью");
            }else{
                if(getAnnotatedSetterForField(field, clazz)!=null){
                    throw new IllegalStateException("Поле "+field.getName()+" не должно иметь аннотации Value, так как класс не является сущностью");
                }
            }
        }
        return true;
    }

    private static Method getAnnotatedSetterForField(Field field, Class<?> clazz){
        String fieldName = field.getName();
        String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().equals(methodName)) {
                if(method.isAnnotationPresent(Value.class))
                    return method;
            }
        }
        return null;

    }
}


