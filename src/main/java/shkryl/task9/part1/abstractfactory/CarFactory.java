/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
