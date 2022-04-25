package CASE_STUDY.models.Facility;

public class Villa extends Facility{
    private String roomStandard;
    private String squareOfPool;
    private int numberOfFloor;

    public Villa(String nameOfService, int squareUsed, int costForRent, int maxPeople,
                 String rentType, String roomStandard, String squareOfPool, int numberOfFloor) {
        super(nameOfService, squareUsed, costForRent, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.squareOfPool = squareOfPool;
        this.numberOfFloor = numberOfFloor;
    }
    public Villa() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getSquareOfPool() {
        return squareOfPool;
    }

    public void setSquareOfPool(String squareOfPool) {
        this.squareOfPool = squareOfPool;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +"nameOfService='"+getNameOfService()+'\'' +
                ", squareUsed=" + getSquareUsed()+
                ", costForRent=" + getCostForRent() +
                ", maxPeople=" + getMaxPeople() +
                ", RentType='" + getRentType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", squareOfPool='" + squareOfPool + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
