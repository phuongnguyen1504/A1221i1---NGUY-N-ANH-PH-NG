package EXAM_MODULE2.model;

public class ExportProduct extends Product {
    private double exportPrice;
    private String country;

    public ExportProduct(double exportPrice, String country) {
        this.exportPrice = exportPrice;
        this.country = country;
    }

    public ExportProduct(int id, String code, String name, Double price, int quantity, String manufacture, double exportPrice, String country) {
        super(id, code, name, price, quantity, manufacture);
        this.exportPrice = exportPrice;
        this.country = country;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("%s,%s",exportPrice,country);
    }
}
