package shkryl.task9.part2.bridge;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        
        Painting painting = new CarBody(new Color());
        painting.paintCarBody("BL");
        painting.paintCarBody("RE");
        painting.paintCarBody("WH"); 
        painting.paintCarBody("OR"); 
    }
}
