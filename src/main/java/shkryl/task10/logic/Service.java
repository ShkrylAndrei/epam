package shkryl.task10.logic;

import shkryl.task10.exceptions.NoValueAnnotationException;
import shkryl.task10.util.Analyzer;

import java.io.IOException;
import java.util.List;

public class Service<T> {
    public List<T> getInstance(Class<?> clazz){
        if(Analyzer.checkEntityAnnotation(clazz)){
            try {
                Analyzer.checkNoValueAnnotationException(clazz);

                try {
                    List<T> list = (List<T>)Analyzer.initFieldsByAnnotaionValue(clazz);
                    return list;

                }catch(Exception e){
                    e.printStackTrace();
                }
            }catch(NoValueAnnotationException e){
                System.out.println(e.toString());
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }else{
            try{
                Analyzer.checkIllegalStateException(clazz);
            }catch(IllegalStateException e){
                System.out.println(e.toString());
            }
        }
        return null;
    }
}
