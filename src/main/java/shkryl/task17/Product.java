package shkryl.task17;

public class Product {
    private int prodId;
    private int category;
    private String title;
    private String actor;
    private double price;
    private int special;
    private int commonProdId;


    public Product() {

    }

    public Product(int prodId, int category, String title, String actor, double price, int special, int commonProdId) {
        this.prodId = prodId;
        this.category = category;
        this.title = title;
        this.actor = actor;
        this.price = price;
        this.special = special;
        this.commonProdId = commonProdId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
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

    public int getCommonProdId() {
        return commonProdId;
    }

    public void setCommonProdId(int commonProdId) {
        this.commonProdId = commonProdId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "prod_id=" + prodId +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", actor='" + actor + '\'' +
                ", price=" + price +
                ", special=" + special +
                ", common_prod_id=" + commonProdId +
                '}';
    }
}
