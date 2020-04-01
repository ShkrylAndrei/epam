package shkryl.task10.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task10.Main;
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
    private static Logger logger = LoggerFactory.getLogger(Main.class);

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
                    logger.error(e.getMessage());
                }
            }catch(NoValueAnnotationException e){
                logger.error(e.toString());
            }catch(IOException e){
                logger.error(e.toString());
            }catch(NumberFormatException e){
                logger.error(e.toString());
            }
        }else{
            try{
                Analyzer.checkIllegalStateException(clazz);
            }catch(IllegalStateException e){
                logger.info(e.toString());
            }
        }
        return list;
    }
}
