package shkryl.task10.util;

import shkryl.task10.annotation.Entity;
import shkryl.task10.annotation.Value;
import shkryl.task10.exceptions.NoValueAnnotationException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class Analyzer {
    private static Map<Field, AnnotationWrapper> fieldAnnotationMap = new HashMap();
    private static int objectCount;
    private static List<FileEntityWrapper> entities;

    private static void initValuesFromFile() throws IOException {
        objectCount = 0;
        entities = null;
        Collection<AnnotationWrapper> values = fieldAnnotationMap.values();
        for (AnnotationWrapper wrapper : values) {
            if (wrapper.getParameterName() != null && wrapper.getParameterName().equals("pathToFile")) {
                List<String> lines = FileUtil.readFile(wrapper.getParameterValue().toString());
                entities = FileUtil.parseFile(lines);
                objectCount = entities.size();
            }
        }
    }

    public static List<Object> initFieldsByAnnotaionValue(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        List<Object> listResult = new ArrayList<>();
        Set<Field> fields = fieldAnnotationMap.keySet();
        initValuesFromFile();
        int i = 0;
        if (objectCount == 0) {
            Object object = clazz.getDeclaredConstructor().newInstance();
            for (Field field : fields) {
                AnnotationWrapper annotationWrapper = fieldAnnotationMap.get(field);
                field.setAccessible(true);
                field.set(object, annotationWrapper.getParameterValue());
            }
            listResult.add(object);
        } else {
            for (int j = 0; j < objectCount; j++) {
                Object object = clazz.getDeclaredConstructor().newInstance();
                for (Field field : fields) {
                    AnnotationWrapper annotationWrapper = fieldAnnotationMap.get(field);
                    field.setAccessible(true);
                    if (annotationWrapper.getParameterName().equals("pathToFile")) {
                        Object value = null;
                        if (field.getType() == String.class) {
                            value = entities.get(j).getName();
                        } else if (field.getType() == int.class) {
                            value = entities.get(j).getAge();
                        }
                        field.set(object, value);
                    } else {
                        field.set(object, annotationWrapper.getParameterValue());
                    }
                }
                listResult.add(object);
            }
        }
        return listResult;
    }

    public static boolean checkEntityAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            System.err.println(clazz.getName() + " has no Entity annotation");
            return false;
        }
        System.out.println("Класс " + clazz.getName() + " имеет аннотацияю Entity");
        return true;

    }

    private static AnnotationWrapper getAnnoWrapper(Class<?> clazz, Value annotation) throws IOException {
        AnnotationWrapper wrapper = null;
        if (!annotation.pathToFile().isEmpty()) {
            String filePath = annotation.pathToFile();
            wrapper = new AnnotationWrapper("pathToFile", filePath);
        } else {
            if (clazz == String.class) {
                wrapper = new AnnotationWrapper("stringValue", annotation.stringValue());
            } else if (clazz == int.class) {
                wrapper = new AnnotationWrapper("intValue", annotation.intValue());
            }
        }
        return wrapper;
    }

    public static boolean checkNoValueAnnotationException(Class<?> clazz) throws IOException {
        fieldAnnotationMap.clear();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Value.class)) {
                Method method = getAnnotatedSetterForField(field, clazz);
                if (method == null) {
                    throw new NoValueAnnotationException("Поле " + field.getName() + " не имеет аннотации Value");
                } else {
                    Value value = method.getAnnotation(Value.class);
                    Parameter setterParameter = method.getParameters()[0];
                    fieldAnnotationMap.put(field, getAnnoWrapper(setterParameter.getType(), value));
                }
            } else {
                Value value = field.getAnnotation(Value.class);
                fieldAnnotationMap.put(field, getAnnoWrapper(field.getType(), value));
            }
        }
        System.out.println("Все поля класса " + clazz.getName() + " имеют аннотацию Value");
        return true;
    }

    public static boolean checkIllegalStateException(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)) {
                throw new IllegalStateException("Поле " + field.getName() + " не должно иметь аннотации Value, так как класс не является сущностью");
            } else {
                if (getAnnotatedSetterForField(field, clazz) != null) {
                    throw new IllegalStateException("Поле " + field.getName() + " не должно иметь аннотации Value, так как класс не является сущностью");
                }
            }
        }
        return true;
    }

    private static Method getAnnotatedSetterForField(Field field, Class<?> clazz) {
        String fieldName = field.getName();
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                if (method.isAnnotationPresent(Value.class))
                    return method;
            }
        }
        return null;

    }
}
