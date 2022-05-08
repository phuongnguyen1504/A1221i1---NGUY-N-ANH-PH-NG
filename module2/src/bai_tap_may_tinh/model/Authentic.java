package bai_tap_may_tinh.model;

public class Authentic extends Product{
    private String warrantyTime;


    public Authentic(String id, String name, String price, String manufacturer, String warrantyTime) {
        super(id, name, price, manufacturer);
        this.warrantyTime = warrantyTime;
    }

    public String getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(String warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Override
    public String toString() {
        return getId()+","+getName()+","+getPrice()+","+getManufacturer()+","+ warrantyTime;
    }
}
