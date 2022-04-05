package ss8_clean_code_va_refactoring.test_mvc.repository.impl;

import ss8_clean_code_va_refactoring.test_mvc.model.Student;
import ss8_clean_code_va_refactoring.test_mvc.repository.IStudentRepository;

public class StudentRepository implements IStudentRepository {
    private static Student[] students=new Student[100];
    private static int numberOfStudent=0;
    @Override
    public void saveStudent(Student student) {
        students[numberOfStudent]=student;
        numberOfStudent++;
    }

    @Override
    public void displayStudent() {
        for (int i=0;i<numberOfStudent;i++){
            System.out.println("Sinh viên "+(i+1));
            System.out.println("Tên: "+students[i].getNameOfStudent()+"\nĐiểm: "+students[i].getPoint()+"\nNgày sinh: "+students[i].getDateOfBirth());
        }
    }

    @Override
    public void deleteStudent(String studentDelete) {
        int index=-1;
        for (int i=0;i<numberOfStudent;i++){
            if (students[i].getNameOfStudent().equals(studentDelete)){
                index=i;
                break;
            }
        }
        if (index!=-1){

            for (int i=index;i<numberOfStudent-1;i++){
                students[i]=students[i+1];
            }
            numberOfStudent--;
        }

    }
}
