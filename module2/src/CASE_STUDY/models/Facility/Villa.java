package CASE_STUDY.models.Facility;

public class Villa extends Facility{
    private int id;
    private String name;
    private int numberOfVilla=0;

    public Villa() {
    }

    public Villa(int numberOfVilla) {
        this.numberOfVilla = numberOfVilla;
    }

    public Villa(int id, String name, int numberOfVilla) {
        this.id = id;
        this.name = name;
        this.numberOfVilla = numberOfVilla;
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

    public int getNumberOfVilla() {
        return numberOfVilla;
    }

    public void setNumberOfVilla(int numberOfVilla) {
        this.numberOfVilla = numberOfVilla;
    }
}
