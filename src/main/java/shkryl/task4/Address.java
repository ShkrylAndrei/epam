package shkryl.task4;

/**
 * Описывает адрес для класса {@link Human}
 *
 */
public class Address {
    private String city;
    private String street;
    private int house;
    private int room;

    public Address() {
    }

    public Address(String city, String street, int house, int room) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.room = room;
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
        return "AddressEntity{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }
}
