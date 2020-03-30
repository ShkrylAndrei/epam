package shkryl.task10;

//????? Нужен ли сервис, если по заданию сущностей максимум 2 (или не 2? )
public class Service<T> {
    public T getInstance(Class<?> clazz){
        if(Analyzer.checkEntityAnnotation(clazz)){
            try {
                Analyzer.checkNoValueAnnotationException(clazz);
                //????????  временный try catch
                try {
                    T t  = (T)Analyzer.initFieldsByAnnotaionValue(clazz);
                    return t;

                }catch(Exception e){
                    e.printStackTrace();
                }
            }catch(NoValueAnnotationException e){
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
