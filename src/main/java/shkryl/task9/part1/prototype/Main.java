package shkryl.task9.part1.prototype;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        IndividualCar carLada = new IndividualCar();
        carLada.setModel("Лада");
        carLada.setColor("Красный");
        carLada.setMaxSpeed(180);
        System.out.println("Выводим на экран объект 1");
        System.out.println(carLada);
        
        IndividualCar carMersedes=(IndividualCar)carLada.getCopy();
        carMersedes.setModel("Мерседес");
        carMersedes.setMaxSpeed(300);
        System.out.println("");
        System.out.println("Выводим на экран объект 2 - Лада преобразованная в Мерседес");
        System.out.println(carMersedes);
    }
 
}
