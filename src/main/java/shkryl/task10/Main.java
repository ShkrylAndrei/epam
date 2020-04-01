package shkryl.task10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shkryl.task10.entity.Car;
import shkryl.task10.entity.Human;
import shkryl.task10.logic.Service;


import java.util.List;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Service<Human> service = new Service<>();
        List<Human> list = service.getInstance(Human.class);
        for (Human h : list) {
            logger.info(h.getName() + " " + h.getAge());
        }


        Service<Car> service2 = new Service<>();
        List<Car> listCar = service2.getInstance(Car.class);
        for (Car car : listCar) {
            logger.info(car.getModel() + " " + car.getMaxSpeed());
        }
    }
}
