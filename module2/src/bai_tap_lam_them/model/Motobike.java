package bai_tap_lam_them.model;

public class Motobike extends Vehicle{
    private String power;

    public Motobike(String power) {
        this.power = power;
    }

    public Motobike() {
    }

    public Motobike(String plate, String brand, String dateOfBirth, String owner, String power) {
        super(plate, brand, dateOfBirth, owner);
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return getPlate()+","+getBrand()+","+getDateOfBirth()+","+getOwner()+","+getPower();
    }
}
