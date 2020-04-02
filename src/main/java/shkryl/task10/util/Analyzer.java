package shkryl.task10.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(Analyzer.class);

    /**
     * Парсит файл с параметрами, инициализирует поле entities, содержащее список сущностей из файла,
     * и objectCount, хранящиее количество сущностей
     *
     * @throws IOException
     */
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

    /**
     * Создает список объектов сущности, заполняя их значениями из параметров аннотации Value
     *
     * @param clazz обрабатываемый класс сущности
     * @return коллекция объектов, с заполненными полями
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IOException
     */
    public static List<Object> initFieldsByAnnotaionValue(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        List<Object> listResult = new ArrayList<>();
        Set<Field> fields = fieldAnnotationMap.keySet();
        try {
            initValuesFromFile();
        } catch (IllegalArgumentException e) {
            logger.error(e.toString());
            return listResult;
        } catch (IndexOutOfBoundsException e) {
            logger.error("{} : Файл параметров заполнен некорректно", e.getClass().getName());
            return listResult;
        }
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

    /**
     * Проверка наличия аннотации Entity
     *
     * @param clazz проверяемый класс
     * @return true, если аннотация есть, в противном случае false
     */
    public static boolean checkEntityAnnotation(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            logger.error("{} has no Entity annotation", clazz.getName());
            return false;
        }
        logger.info("Класс {} имеет аннотацию Entity", clazz.getName());
        return true;

    }

    /**
     * Забирает значение из аннотации и оборачивает его в обертку AnnotationWrapper
     *
     * @param clazz      обрабатываемый класс сущности
     * @param annotation обрабатываемая аннотация
     * @return возвращает обертку AnnotationWrapper
     * @throws IOException
     */
    private static AnnotationWrapper getAnnoWrapper(Class<?> clazz, Value annotation) throws IOException {
        AnnotationWrapper wrapper = null;
        if (!annotation.pathToFile().isEmpty()) {
            String filePath = annotation.pathToFile();
            wrapper = new AnnotationWrapper("pathToFile", filePath);
        } else {
            if (!annotation.stringValue().equals("default name")) {
                if (clazz == int.class) {
                    int age = Integer.parseInt(annotation.stringValue());
                    wrapper = new AnnotationWrapper("intValue", age);
                } else if (clazz == String.class) {
                    wrapper = new AnnotationWrapper("stringValue", annotation.stringValue());
                }
            } else if (clazz == int.class) {
                wrapper = new AnnotationWrapper("intValue", annotation.intValue());
            } else if (clazz == String.class) {
                wrapper = new AnnotationWrapper("stringValue", annotation.stringValue());
            }
        }
        return wrapper;
    }

    /**
     * Заполняет карту аннотаций fieldAnnotationMap при условии, что все поля или сеттеры сущности имеют аннотацию Value
     *
     * @param clazz обрабатываемый класс
     * @return true если все поля имеют аннотацию Value, иначе - false
     * @throws IOException
     */
    public static boolean loadFieldAnnotationMap(Class<?> clazz) throws IOException {
        fieldAnnotationMap.clear();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Value.class)) {
                Method method = getAnnotatedSetterForField(field, clazz);
                Value value = method.getAnnotation(Value.class);
                Parameter setterParameter = method.getParameters()[0];
                fieldAnnotationMap.put(field, getAnnoWrapper(setterParameter.getType(), value));
            } else {
                Value value = field.getAnnotation(Value.class);
                fieldAnnotationMap.put(field, getAnnoWrapper(field.getType(), value));
            }
        }
        logger.info("Все поля класса {} имеют аннотацию Value", clazz.getName());
        return true;
    }

    /**
     * Проверяет наличие аннотации Value в классе, не имеющим аннотации Entity
     *
     * @param clazz обрабатываемый класс
     * @return true если поля не имеют аннотации Value, иначе - false
     */
    public static boolean checkIllegalStateException(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)) {
                throw new IllegalStateException("Поле " + field.getName() + " не должно иметь аннотации Value, так как класс не является сущностью");
            } else {
                try {
                    if (getAnnotatedSetterForField(field, clazz) != null) {
                        throw new IllegalStateException("Поле " + field.getName() + " не должно иметь аннотации Value, так как класс не является сущностью");
                    }
                } catch (NoValueAnnotationException e) {
                }
            }
        }
        return true;
    }

    /**
     * Ищет сеттер для поля без аннотации Value и проверяет, что сеттер помечен аннотацией Value
     *
     * @param field проверяемое поле
     * @param clazz орабатываемый класс
     * @return возвращает метод, если он помечен аннотацией Value, иначе - выбрасывает исключение NoValueAnnotationException
     */
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
        throw new NoValueAnnotationException("Поле " + field.getName() + " не имеет аннотации Value");
    }
}
