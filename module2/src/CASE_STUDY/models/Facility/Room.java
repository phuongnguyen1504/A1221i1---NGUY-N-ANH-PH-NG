package CASE_STUDY.models.Facility;

public class Room extends Facility {
    private String FreeService;

    public Room() {
    }

    public Room(String nameOfService, int squareUsed, int costForRent, int maxPeople,
                String rentType, String freeService) {
        super(nameOfService, squareUsed, costForRent, maxPeople, rentType);
        FreeService = freeService;
    }

    public String getFreeService() {
        return FreeService;
    }

    public void setFreeService(String freeService) {
        FreeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +"nameOfService='"+getNameOfService()+'\'' +
                ", squareUsed=" + getSquareUsed()+
                ", costForRent=" + getCostForRent() +
                ", maxPeople=" + getMaxPeople() +
                ", RentType='" + getRentType() + '\'' +
                "FreeService='" + FreeService + '\'' +
                '}';
    }
}
