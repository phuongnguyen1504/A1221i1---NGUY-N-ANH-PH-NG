package CASE_STUDY.models.Person;

public class Employee extends Person{
    private String level;
    private String position;
    private int salary;


    public Employee(String level, String position, int salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(String codeOfPerson, String name, String dateOfBirth, String gender,
                    int id, int tel, String email, String level, String position, int salary) {
        super(codeOfPerson, name, dateOfBirth, gender, id, tel, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
