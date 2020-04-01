package shkryl.task10.logic;

import shkryl.task10.exceptions.NoValueAnnotationException;
import shkryl.task10.util.Analyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис создания объектов с применением рефлексии
 * @param <T> тип создаваемого объекта
 */
public class Service<T> {
    /**
     * Создает объект класса
     * @param clazz Class создаваемого объекта
     * @return коллекцию созданных объектов
     */
    public List<T> getInstance(Class<?> clazz){
        List<T> list = new ArrayList();
        if(Analyzer.checkEntityAnnotation(clazz)){
            try {
                Analyzer.loadFieldAnnotationMap(clazz);
                try {
                    list = (List<T>)Analyzer.initFieldsByAnnotaionValue(clazz);
                    return list;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }catch(NoValueAnnotationException e){
                System.out.println(e.toString());
            }catch(IOException e){
                System.out.println(e.toString());
            }catch(NumberFormatException e){
                System.out.println(e.toString());
            }
        }else{
            try{
                Analyzer.checkIllegalStateException(clazz);
            }catch(IllegalStateException e){
                System.out.println(e.toString());
            }
        }
        return list;
    }
}
