package bai_tap_lam_them.model;

public class Truck extends Vehicle{
    private String weight;

    public Truck() {
    }

    public Truck(String weight) {
        this.weight = weight;
    }

    public Truck(String plate, String brand, String dateOfBirth, String owner, String weight) {
        super(plate, brand, dateOfBirth, owner);
        this.weight = weight;
    }

    public Truck(String plate, String brand, String dateOfBirth, String owner) {
        super(plate, brand, dateOfBirth, owner);
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getPlate()+","+getBrand()+","+getDateOfBirth()+","+getOwner()+","+getWeight();
    }
}
