package shkryl.task10.entity;

import shkryl.task10.annotation.Entity;
import shkryl.task10.annotation.Value;

@Entity
public class Human {
    private int age;
    @Value(pathToFile = "list_values.txt")
    private String name;

    public int getAge() {
        return age;
    }

    @Value(stringValue = "30", pathToFile = "list_values.txt")
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

