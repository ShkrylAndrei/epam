package shkryl.task10.part2;


import shkryl.task10.part2.Value;


public class Human {
    @Value
    private int age;
    @Value(name = "Peter", pathToFile = "list_value.txt")
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

    public void setName(String name) {
        this.name = name;
    }
}

