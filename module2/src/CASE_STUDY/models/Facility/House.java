package CASE_STUDY.models.Facility;

public class House extends Facility{
    private int id;
    private String name;
    private int numberOfHouse=10;

    public House() {
    }

    public House(int id, String name, int numberOfHouse) {
        this.id = id;
        this.name = name;
        this.numberOfHouse = numberOfHouse;
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

    public int getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }
}
