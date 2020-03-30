package shkryl.task9.part1.factorymethod;

public abstract class Refuel {

    /**
     * Выполняет заправку
     */
    public void startRefuel(){
        Station station = createStation();
        station.refuel();

    }

    /**
     * Фабричный метод
     */
    public abstract Station createStation();
}
