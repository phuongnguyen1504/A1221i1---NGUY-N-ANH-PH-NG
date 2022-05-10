package FuramaCaseStudy.model;

import FuramaCaseStudy.util.ConstantUtil;

public class Employee extends Person{
    private ConstantUtil.Degree degree;
    private ConstantUtil.Position position;
    private double salary;

    public Employee(){};

    public Employee(int id, String code, String fullName, String birthday, ConstantUtil.Gender gender, String phone, String email, String address, ConstantUtil.Degree degree, ConstantUtil.Position position, double salary) {
        super(id, code, fullName, birthday, gender, phone, email, address);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public ConstantUtil.Degree getDegree() {
        return degree;
    }

    public void setDegree(ConstantUtil.Degree degree) {
        this.degree = degree;
    }

    public ConstantUtil.Position getPosition() {
        return position;
    }

    public void setPosition(ConstantUtil.Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        return getId()== ((Employee)o).getId();
    }

    @Override
    public String toString() {
        return  getId() +
                "," + getCode() +
                "," + getFullName() +
                "," + getBirthday() +
                "," + getGender() +
                "," + getPhone() +
                "," + getEmail() +
                "," + getAddress() +
                "," + degree +
                "," + position +
                "," + salary;
    }
}
