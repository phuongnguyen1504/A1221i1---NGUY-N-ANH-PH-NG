package bai_tap_lam_them.model;

public class Car extends Vehicle{
    private String seat;
    private String type;

    public Car() {
    }

    public Car(String seat, String type) {
        this.seat = seat;
        this.type = type;
    }

    public Car(String plate, String brand, String dateOfBirth, String owner, String seat, String type) {
        super(plate, brand, dateOfBirth, owner);
        this.seat = seat;
        this.type = type;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getPlate()+","+getBrand()+","+getDateOfBirth()+","+getOwner()+","+getSeat()+","+getType();
    }
}
