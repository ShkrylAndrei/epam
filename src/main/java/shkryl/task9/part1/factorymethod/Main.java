package shkryl.task9.part1.factorymethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Refuel refuel = null;
        System.out.println("Каким топливом заправить автомобиль?");
        System.out.println("1. Бензин");
        System.out.println("2. Электричество");
        String userInput = new Scanner(System.in).next();
        if(userInput.equals("1")){
            refuel = new PetrolRefuel();
        }else if(userInput.equals("2")){
            refuel = new ElectricRefuel();
        }else{
            System.out.println("Неверный выбор");
        }
        if(refuel!=null)
        {
            refuel.startRefuel();
        }
    }
}
