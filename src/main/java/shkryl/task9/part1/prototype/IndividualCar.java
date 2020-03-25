package shkryl.task9.part1.prototype;



/**
 *
 * @author Admin
 */
public class IndividualCar implements CarI{
    private String model;
    private String color;
    private int maxSpeed;

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    
    
    @Override
    public CarI getCopy() throws CloneNotSupportedException {
        return (CarI)super.clone();
    }

    @Override
    public String toString() {
        return "IndividualCar{" + "model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + '}';
    }
    
    
    
    
}
