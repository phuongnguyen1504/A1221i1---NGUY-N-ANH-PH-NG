package EXAM_MODULE2.model;

public abstract class Product {
    private int id;
    private String code;
    private String name;
    private Double price;
    private int quantity;
    private String manufacture;


    public Product() {
    }

    public Product(int id, String code, String name, Double price, int quantity, String manufacture) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,", id,code, name, price,quantity,manufacture);
    }
}
