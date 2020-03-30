package shkryl.task9.part1.factorymethod;

/**
 * Описывает электрическую колонку
 */
public class ElectricStation implements Station {
    @Override
    public void refuel() {
        System.out.println("Автомобиль заправлен электричеством");
    }
}
