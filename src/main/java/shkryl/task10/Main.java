package shkryl.task10;


import shkryl.task10.entity.Human;
import shkryl.task10.logic.Service;

import java.util.List;

public class Main {
    public Character aCharacter;


    public static void main(String[] args) {
//через сервис:
        Service<Human> service = new Service<>();
        List<Human> list  = service.getInstance(Human.class);
        for(Human h : list) {
            System.out.println(h.getName() + " " + h.getAge());
        }
//
//        Service<Car> service2 = new Service<>();
//        Car car = service2.getInstance(Car.class);
//        System.out.println(car.getModel()+" "+car.getMaxSpeed());


//        Class<?> clazz = Human.class;
//        if(Analyzer.checkEntityAnnotation(clazz)){
//            try {
//                Analyzer.checkNoValueAnnotationException(clazz);
//                //временный try catch
//                try {
//                    Human human = (Human)Analyzer.initFieldsByAnnotaionValue(clazz);
//                    System.out.println(human.getName()+" "+human.getAge());
//
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }catch(NoValueAnnotationException e){
//                System.out.println(e.toString());
//            }
//        }else{
//            try{
//                Analyzer.checkIllegalStateException(clazz);
//            }catch(IllegalStateException e){
//                System.out.println(e.toString());
//            }
//        }
    }

}
