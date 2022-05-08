package bai_tap_may_tinh.model;

public class HandGood extends Product {
    private String countryName;

    public HandGood(String countryName) {
        this.countryName = countryName;
    }

    public HandGood(String id, String name, String price, String manufacturer, String countryName) {
        super(id, name, price, manufacturer);
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return getId()+","+getName()+","+getPrice()+","+getManufacturer()+","+ countryName;
    }
}
