package shkryl.task9.part1.factorymethod;

public class PetrolRefuel extends Refuel {
    @Override
    public Station createStation() {
        return new PetrolStation();
    }
}
