package shkryl.task9.part1.prototype;

public class Phone implements MyClonable {
    private String model;
    private int price;

    public Phone(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public MyClonable getCopy() {
        Phone cloneObject = new Phone(model, price);
        return cloneObject;
    }
}
