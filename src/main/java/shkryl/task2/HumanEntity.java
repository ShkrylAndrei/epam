package shkryl.task2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HumanEntity {
    private int id;
    private String name;
    private AddressEntity address;
    //Как правильно дату сделать, сделал пока String
    private Date birthDate;

    public HumanEntity() {
    }

    public HumanEntity(int id, String name, AddressEntity address, Date birthDate) {
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

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
