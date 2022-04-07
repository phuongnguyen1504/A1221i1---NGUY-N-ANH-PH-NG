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
        System.out.printf("%-12s%-12s%s", "Ten","Diem","Ngay sinh\n");
        for (int i=0;i<numberOfStudent;i++){
            System.out.printf("%-12s%-12s%s",students[i].getNameOfStudent(),students[i].getPoint(),students[i].getDateOfBirth());
            System.out.println();
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
