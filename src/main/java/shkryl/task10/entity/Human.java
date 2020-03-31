package shkryl.task10.entity;

import shkryl.task10.annotation.Entity;
import shkryl.task10.annotation.Value;

@Entity
public class Human {
    @Value(pathToFile = "list_values.txt")
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Value(pathToFile = "list_values.txt")
    public void setName(String name) {
        this.name = name;
    }
}

