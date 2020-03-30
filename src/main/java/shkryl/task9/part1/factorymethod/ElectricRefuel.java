package shkryl.task9.part1.factorymethod;

public class ElectricRefuel extends Refuel {
    @Override
    public Station createStation() {
        return new ElectricStation();
    }
}
