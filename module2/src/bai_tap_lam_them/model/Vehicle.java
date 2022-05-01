package bai_tap_lam_them.model;

public abstract class Vehicle {
    private String plate;
    private String brand;
    private String dateOfBirth;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String plate, String brand, String dateOfBirth, String owner) {
        this.plate = plate;
        this.brand = brand;
        this.dateOfBirth = dateOfBirth;
        this.owner = owner;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
