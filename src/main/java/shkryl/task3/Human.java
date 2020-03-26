package shkryl.task3;

import java.util.Objects;

/**
 * Описывает класс Human
 */
public class Human {
    private String fio;
    private int age;
    private Address address;

    /**
     * Конструктор, инициализирует поля класса
     *
     * @param fio     фио
     * @param age     возраст
     * @param address адрес
     */
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

    /**
     * Сравнивает объекты класса Human на равенство
     *
     * @param o объект класса Human для сравнения
     * @return возвращает true, если у обоих объектов совпадает fio, age, address, иначе - false
     */
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

    /**
     * Генерирует hash code на основе fio, age, address
     *
     * @return вовзращает сгенерированный hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(fio, age, address);
    }

    /**
     * Формирует строку, описывающий объект класса Human, содержащую поля fio, age, address
     *
     * @return возвращает сформированную строку
     */
    @Override
    public String toString() {
        return "Human{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }


}
