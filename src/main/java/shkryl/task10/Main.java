package shkryl.task10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public Character aCharacter;


    public static void main(String[] args) {
        Class cl=null;

        {
            try {
                cl = Class.forName("shkryl.task10.Human");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        if(!cl.isAnnotationPresent(Entity.class)){
            System.err.println("no annotation");
        } else {
            System.out.println("class annotated ; name  -  " + cl.getAnnotation(Entity.class));
        }
        boolean isMoreThanOneAnnotationField=false;
        Field[] field = cl.getDeclaredFields();
        for(Field fd: field){
            if(fd.isAnnotationPresent(Value.class)) {
                isMoreThanOneAnnotationField=true;
                System.out.println(fd);
            }

        }

        if (isMoreThanOneAnnotationField == false){
            try{
                throw new NoValueAnnotationException("В данном классе нет аннотации Value");
            }catch (NoValueAnnotationException e) {

            }
        }else{
            System.out.println("Ошибок нет, аннотация Value в классе присутствует");
        }

        //-------------------------------------
        Human human1 = new Human();
        Field f=null;
        try {
             f = human1.getClass().getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Value annotation = f.getAnnotation(Value.class);
        if (annotation != null) {
            String name = annotation.name();
            System.out.println("!!!!!!!!!!"+name);
        }


        System.out.println(human1.getName());



       // Human human2 = new Human();

       // System.out.println(human2.getName());

//        StrangeReflectionExample instance = new StrangeReflectionExample();
//        Field field = StrangeReflectionExample.class.getField("aCharacter");
//        Field type = Field.class.getDeclaredField("type");
//        type.setAccessible(true);
//        type.set(field, String.class);
//        field.set(instance, 'A');
//        System.out.println(instance.aCharacter);
    //}

    }

}
