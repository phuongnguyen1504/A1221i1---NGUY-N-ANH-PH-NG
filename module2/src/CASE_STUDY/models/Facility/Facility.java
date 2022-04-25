package CASE_STUDY.models.Facility;

public abstract class Facility {
    private String nameOfService;
    private int squareUsed;
    private int costForRent;
    private int maxPeople;
    private String RentType;

    public Facility(String nameOfService, int squareUsed, int costForRent, int maxPeople, String rentType) {
        this.nameOfService = nameOfService;
        this.squareUsed = squareUsed;
        this.costForRent = costForRent;
        this.maxPeople = maxPeople;
        RentType = rentType;
    }

    public Facility() {
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public int getSquareUsed() {
        return squareUsed;
    }

    public void setSquareUsed(int squareUsed) {
        this.squareUsed = squareUsed;
    }

    public int getCostForRent() {
        return costForRent;
    }

    public void setCostForRent(int costForRent) {
        this.costForRent = costForRent;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return RentType;
    }

    public void setRentType(String rentType) {
        RentType = rentType;
    }

    @Override
    public String toString() {
        return "nameOfService='" + nameOfService + '\'' +
                ", squareUsed=" + squareUsed +
                ", costForRent=" + costForRent +
                ", maxPeople=" + maxPeople +
                ", RentType='" + RentType + '\'' +
                '}';
    }
}
