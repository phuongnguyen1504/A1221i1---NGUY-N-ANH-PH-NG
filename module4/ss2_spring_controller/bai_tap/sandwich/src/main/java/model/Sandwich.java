package model;

public class Sandwich {
    private int id;
    private String c;

    public Sandwich() {
    }

    public Sandwich(int id, String c) {
        this.id = id;
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
