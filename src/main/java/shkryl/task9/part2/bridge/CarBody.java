package shkryl.task9.part2.bridge;

/**
 *
 * @author Admin
 */
public class CarBody extends Painting{

    public CarBody(Palette palette) {
        super(palette);
    }
    
    
    @Override
    public void paintCarBody(String color) {
       if (color.equals("BL")){
           palette.setColor("BLACK");
       }else if (color.equals("RE")){
           palette.setColor("RED");           
       }else if (color.equals("WH")){
           palette.setColor("WHITE");           
       }else if (color.equals("GR")){
           palette.setColor("GREEN");           
       }else{
           System.out.println("Нельзя покрасить в цвет "+color);
       }
    }    
}


    

