package ss8_clean_code_va_refactoring.demo_mvc.repository.impl;

import ss8_clean_code_va_refactoring.demo_mvc.model.Student;
import ss8_clean_code_va_refactoring.demo_mvc.repository.IStudentRepository;

public class StudentRepository implements IStudentRepository {
   private static Student[] students = new Student[1000];
   private static int numberPeopleOfCompany =0;
    @Override
    public void saveStudent(Student student) {
        students[numberPeopleOfCompany] = student;
        numberPeopleOfCompany++;
    }

    @Override
    public void deleteStudent(String studentDelete) {
        int index=-1;
        for(int i=0;i<numberPeopleOfCompany;i++){
            if (students[i].getNameStudent()==studentDelete)){
                for (int j=i;j<numberPeopleOfCompany-1;j++){
                    students[j]=students[j+1];
                }
                numberPeopleOfCompany--;
            }
        }
    }

    @Override
    public void displayStudent() {
        for (Student student : students) {
            if (student==null) {
                continue;
            } else {
                System.out.println("Tên:" + student.getNameStudent()+ "Điểm:" + student.getPoint());
            }
        }
    }
}
