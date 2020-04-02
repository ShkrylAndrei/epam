package shkryl.task10.entity;

import shkryl.task10.annotation.Entity;
import shkryl.task10.annotation.Value;

@Entity
public class Car {
    @Value
    private String model;
    @Value
    private int maxSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
