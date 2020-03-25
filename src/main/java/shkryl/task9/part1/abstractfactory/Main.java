package shkryl.task9.part1.abstractfactory;

public class Main {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car carPetrol = factory.getCar(CarType.PETROL);
        Car carGas = factory.getCar(CarType.GAS);
        Car carElecticity = factory.getCar(CarType.ELECTRICITY);

        carPetrol.refuel();
        carGas.refuel();
        carElecticity.refuel();
    }
}
