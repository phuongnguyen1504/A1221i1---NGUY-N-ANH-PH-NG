package CASE_STUDY.models.Facility;

public class House extends Facility{
    private String roomStandard;
    private int numberOfFloor;

    public House() {
    }

    public House(String nameOfService, int squareUsed, int costForRent, int maxPeople,
                 String rentType, String roomStandard, int numberOfFloor) {
        super(nameOfService, squareUsed, costForRent, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +"nameOfService='"+getNameOfService()+'\'' +
                ", squareUsed=" + getSquareUsed()+
                ", costForRent=" + getCostForRent() +
                ", maxPeople=" + getMaxPeople() +
                ", RentType='" + getRentType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
