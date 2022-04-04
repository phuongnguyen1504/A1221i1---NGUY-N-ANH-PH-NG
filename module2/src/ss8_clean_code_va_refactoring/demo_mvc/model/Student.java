package ss8_clean_code_va_refactoring.demo_mvc.model;

public class Student {
    private String nameStudent;
    private double point;
    private String dateOfBirth;

    public Student() {
    }

    public Student(String nameStudent, double point, String dateOfBirth) {
        this.nameStudent = nameStudent;
        this.point = point;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name) {
        this.nameStudent=name;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
