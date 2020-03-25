package shkryl.task9.part1.abstractfactory;



/**
 *
 * @author Admin
 */
public class CarFactory {
    public Car getCar(CarType type) {
        Car toReturn = null;
        if (type==type.PETROL){
            toReturn = new CarPetrol();
        }else if (type==type.GAS){
            toReturn = new CarGas();
        }else if (type==type.ELECTRICITY){
            toReturn = new CarElectricity();
        }else{
            throw new IllegalArgumentException("Неккоректный вид топлива:" + type);
        }
       
        return toReturn;
    }
}
