package shkryl.task3;



public class Address implements Comparable<Address>{
    private String city;
    private String street;
    private int house;
    private int room;

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


    @Override
    public int hashCode() {
        return 31*(city.charAt(0)+street.charAt(0)+house+room);

    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", room=" + room +
                '}';
    }

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
