/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shkryl.task9.part1.abstractfactory;

/**
 * Пример взял отсюда https://vertex-academy.com/tutorials/ru/pattern-factory-java/
 * для prototype - https://refactoring.guru/ru/design-patterns/prototype/java/example вообще ниче не понял
 * 
 * 2. адаптер
 * https://refactoring.guru/ru/design-patterns/adapter/java/example
 * http://sh2533.blogspot.com/2011/09/blog-post.html
 * 
 * 2. мост
 * http://sh2533.blogspot.com/2011/10/bridge.html
 * https://refactoring.guru/ru/design-patterns/bridge/java/example
 * @author Admin
 */
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
