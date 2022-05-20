package EXAM_MODULE2.model;

public class ImportProduct extends Product {
    private double importPrice;
    private String country;
    private double importTax;

    public ImportProduct(Double importPrice, String country, Double importTax) {
        this.importPrice = importPrice;
        this.country = country;
        this.importTax = importTax;
    }

    public ImportProduct(int id, String code, String name, Double price, int quantity, String manufacture, Double importPrice, String country, Double importTax) {
        super(id, code, name, price, quantity, manufacture);
        this.importPrice = importPrice;
        this.country = country;
        this.importTax = importTax;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Double importPrice) {
        this.importPrice = importPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getImportTax() {
        return importTax;
    }

    public void setImportTax(Double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("%s,%s,%s",importPrice,country,importTax);
    }
}
