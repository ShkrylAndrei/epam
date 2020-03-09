package shkryl.task3;

import java.util.Comparator;
import java.util.Objects;

public class Human {
    private String fio;
    private int age;
    private Address address;

    public Human(String fio, int age, Address address) {
        this.fio = fio;
        this.age = age;
        this.address = address;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Human) {
            Human human = (Human) o;
            return fio.equals(human.fio) &&
                    age == human.age &
                            address.equals(human.address);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, age, address);
    }


    @Override
    public String toString() {
        return "Human{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }




}
