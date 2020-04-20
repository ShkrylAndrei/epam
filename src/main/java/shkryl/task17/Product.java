package shkryl.task17;

public class Product {
    private int prod_id;
    private int category;
    private String title;
    private String actor;
    private double price;
    private int special;
    private int common_prod_id;


    public Product(){

    }
    public Product(int prod_id, int category, String title, String actor, double price, int special, int common_prod_id) {
        this.prod_id = prod_id;
        this.category = category;
        this.title = title;
        this.actor = actor;
        this.price = price;
        this.special = special;
        this.common_prod_id = common_prod_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public int getCommon_prod_id() {
        return common_prod_id;
    }

    public void setCommon_prod_id(int common_prod_id) {
        this.common_prod_id = common_prod_id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "prod_id=" + prod_id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", price=" + price +
                ", special=" + special +
                ", common_prod_id=" + common_prod_id +
                '}';
    }
}
