package shkryl.task9.part1.prototype;

public class IndividualCar implements MyClonable {
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
    public MyClonable getCopy() {
        IndividualCar cloneObject = new IndividualCar();
        cloneObject.setModel(model);
        cloneObject.setColor(color);
        cloneObject.setMaxSpeed(maxSpeed);
        return cloneObject;
    }

    @Override
    public String toString() {
        return "IndividualCar{" + "model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + '}';
    }
}
