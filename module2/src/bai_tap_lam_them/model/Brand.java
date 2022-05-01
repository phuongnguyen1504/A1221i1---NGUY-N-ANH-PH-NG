package bai_tap_lam_them.model;

public class Brand {
    private String brandCode;
    private String name;
    private String country;

    public Brand() {
    }

    public Brand(String brandCode, String name, String country) {
        this.brandCode = brandCode;
        this.name = name;
        this.country = country;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
