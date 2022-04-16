package ss12_DSA_Java_Collection_Framework.baitap.baitap1_luyentap_arraylist_linkedlist_trong_javacollection;

public class Product {
    private int id;
    private String nameProduct;
    private int price;

    public Product() {
    }

    public Product(int id, String nameProduct, int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
