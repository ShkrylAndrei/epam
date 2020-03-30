package shkryl.task10;

@Entity
public class Human {
    @Value(pathToFile = "list_value.txt")
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
    @Value (pathToFile = "list_value.txt")
    public void setName(String name) {
        this.name = name;
    }
}

