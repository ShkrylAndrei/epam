package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DTO для сущности Human
 */
public class HumanDto {

    private int id;
    private String name;
    //Как правильно указывать дату, пока указал String
    private Date birthDate;

    private String city;
    private String street;
    private int house;
    private int room;

    public HumanDto() {
    }

    /**
     * Конструктор с параметрами
     *
     * @param id        - id
     * @param name      - имя
     * @param birthDate - дата рождения
     * @param city      - город
     * @param street    - улица
     * @param house     - номер дома
     * @param room      - квартира
     */
    public HumanDto(int id, String name, Date birthDate, String city, String street, int house, int room) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.city = city;
        this.street = street;
        this.house = house;
        this.room = room;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }


    @Override
    public String toString() {
        SimpleDateFormat birthDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        return "HumanDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDateFormat.format(birthDate) + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }
}
