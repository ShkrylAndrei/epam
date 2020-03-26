package shkryl.task9.part1.factorymethod;

/**
 * Описывает бензиновую запровочную колонку
 */
public class PetrolStation implements Station {
    @Override
    public void refuel() {
        System.out.println("Автомобиль заправлен безнином");
    }
}
