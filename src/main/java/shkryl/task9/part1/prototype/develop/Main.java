package shkryl.task9.part1.prototype.develop;

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

        IndividualCar carClone=(IndividualCar)carLada.getCopy();

        System.out.println("Выводим на экран исходный объект");
        System.out.println(carLada);
        System.out.println("Выводим на экран склонированный объект");
        System.out.println(carClone);

        System.out.println("Внесем изменение в исходный объект и проверим, что они не повлияли на клон");
        carLada.setModel("Мерседес");

        System.out.println("Выводим на экран измененный исходный объект");
        System.out.println(carLada);
        System.out.println("Выводим на экран склонированный объект");
        System.out.println(carClone);


        System.out.println("#################");
        Phone phone = new Phone("Iphone X", 50000);

        Phone phoneClone = (Phone)phone.getCopy();
        phone.setModel("Sumsung"); //изменим поле
        System.out.println(phone);
        System.out.println(phoneClone);
    }
 
}
