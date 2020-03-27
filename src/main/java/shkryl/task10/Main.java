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
        boolean value=false;
        Field[] field = cl.getFields();
        for(Field fd: field){
            if(fd.isAnnotationPresent(Value.class)) {
                value=true;
                System.out.println(fd);
            }

        }


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
