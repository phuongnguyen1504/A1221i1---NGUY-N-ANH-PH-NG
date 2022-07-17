package thi.thi.model;

import java.util.Date;

public class Object {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String description;
    private int code_category;
    private String category;

    public Object() {
    }

    public Object(String name, double price, int quantity, String color, String description, int code_category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.code_category = code_category;
    }

    public Object(int id, String name, double price, int quantity, String color, String description, int code_category, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.code_category = code_category;
        this.category = category;
    }

    public Object(String name, double price, int quantity, String color, String description, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode_category() {
        return code_category;
    }

    public void setCode_category(int code_category) {
        this.code_category = code_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
