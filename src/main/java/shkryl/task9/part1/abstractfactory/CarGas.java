package shkryl.task9.part1.abstractfactory;

/**
 *
 * @author Admin
 */
public class CarGas implements Car{

    @Override
    public void refuel() {
        System.out.println("Меня заправили газом");
    }
    
}
