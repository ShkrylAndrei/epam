package shkryl.task10;

import shkryl.task10.entity.Car;
import shkryl.task10.entity.Human;
import shkryl.task10.logic.Service;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Service<Human> service = new Service<>();
        List<Human> list = service.getInstance(Human.class);
        for (Human h : list) {
            System.out.println(h.getName() + " " + h.getAge());
        }

        System.out.println();


        Service<Car> service2 = new Service<>();
        List<Car> listCar = service2.getInstance(Car.class);
        for (Car car : listCar) {
            System.out.println(car.getModel() + " " + car.getMaxSpeed());
        }
    }
}
