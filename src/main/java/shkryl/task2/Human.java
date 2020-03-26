package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс описывающий сущность Human
 */
public class Human {
    private int id;
    private String name;
    private Address address;
    private Date birthDate;

    public Human() {
    }

    /**
     * Конструктор с параметрами
     *
     * @param id        - id
     * @param name      - имя
     * @param address   - адрес
     * @param birthDate - дата рождения
     */
    public Human(int id, String name, Address address, Date birthDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Формирует строку содержащую поля id,name,address,birthDate
     *
     * @return возвращает сформированную строку
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "HumanEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", birthDate='" + sdf.format(birthDate) + '\'' +
                '}';
    }
}
