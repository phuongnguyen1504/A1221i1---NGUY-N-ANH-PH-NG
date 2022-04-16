package ss10_dsa.repository.impl;

import ss10_dsa.model.Student;
import ss10_dsa.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
   private static List<Student> students = new LinkedList<>();
//   private static int numberPeopleOfCompany =0;
    @Override
    public void saveStudent(Student student) {
        students.add(student);
//        numberPeopleOfCompany++;
    }
    public void displayAllStudent() {
        for(Student student: students) {
            System.out.println(student);
        }
        for(int i =0; i<students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

}
