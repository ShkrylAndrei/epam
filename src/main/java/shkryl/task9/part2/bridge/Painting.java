package shkryl.task9.part2.bridge;

/**
 *
 * @author Admin
 */
public abstract class Painting {
    protected Palette palette;
    
    protected  Painting(Palette palette){
        this.palette = palette;
    }
    
    public abstract void paintCarBody(String color);
    
}
