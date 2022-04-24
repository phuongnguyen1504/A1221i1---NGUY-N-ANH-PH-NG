package CASE_STUDY.models.Facility;

public class Room extends Facility{
    private int id;
    private String name;
    private int numberOfRoom=0;

    public Room() {
    }

    public Room(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public Room(int id, String name, int numberOfRoom) {
        this.id = id;
        this.name = name;
        this.numberOfRoom = numberOfRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }
}
