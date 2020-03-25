package shkryl.task9.part2.bridge;

/**
 *
 * @author Admin
 */
public class Color implements Palette{

    @Override
    public void setColor(String color) {
        System.out.println("Кузов покашен в "+color+" цвет");
    }
    
}