package shkryl.task3;

/**
 * Описывает адрес для Human
 */
public class Address implements Comparable<Address>{
    private String city;
    private String street;
    private int house;
    private int room;

    /**
     * Конструктор инициализирует поля класса
     * @param city название города
     * @param street улица
     * @param house номер дома
     * @param room квартира
     */
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

    /**
     * Сравнивает объекты класса Address на равенство
     * @param o объект класса Address для сравнения
     * @return возвращает true, если у обоих объектов совпадает city, street, house и room, иначе - false
     */
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o instanceof Address){
            Address address=(Address)o;
            return  city.equals(address.city) &&
                    street.equals(address.street) &&
                    house==address.house &&
                    room==address.room;

        }
        return false;
    }

    /**
     * Генерирует hash code на основе city, street, house, room
     * @return вовзращает сгенерированный hash code
     */
    @Override
    public int hashCode() {
        return 31*(city.charAt(0)+street.charAt(0)+house+room);

    }

    /**
     * Формирует строку, описывающий объект класса Address, содержащую поля city, street, house, room
     * @return возвращает сформированную строку
     */
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }

    /**
     * Сравнивает два объекта класса Address на основе полей city, street, house, room для их сортировки
     * @param o объект класса Address
     * @return возвращает 0, если значения полей равны
     * возвращает число больше нуля, если адрес в параметре больше текущего адреса
     * в остальных случаях - число меньше нуля
     */
    @Override
    public int compareTo(Address o) {
        int diff = city.compareTo(o.city);
        if(diff == 0){
            diff = street.compareTo(o.street);
            if(diff==0){
                diff = house - o.house;
                if(diff==0){
                    return room - o.room;
                }
                return diff;
            }
            return diff;
        }
        return diff;
    }
}
