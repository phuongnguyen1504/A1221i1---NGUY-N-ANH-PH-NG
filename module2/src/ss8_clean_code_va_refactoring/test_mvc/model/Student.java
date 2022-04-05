package ss8_clean_code_va_refactoring.test_mvc.model;

public class Student {
    private String nameOfStudent;
    private double point;
    private String dateOfBirth;

    public Student() {
    }

    public Student(String nameOfStudent, double point, String dateOfBirth) {
        this.nameOfStudent = nameOfStudent;
        this.point = point;
        this.dateOfBirth = dateOfBirth;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
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
