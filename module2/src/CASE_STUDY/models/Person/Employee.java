package CASE_STUDY.models.Person;

public class Employee extends Person{
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;

    public Employee() {
    }

    public Employee(int id, String name, String age, String gender) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = age;
        this.gender = gender;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
