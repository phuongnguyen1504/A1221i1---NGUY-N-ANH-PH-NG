package ss14_sort.repository.impl;

import ss14_sort.model.Student;
import ss14_sort.repository.IStudentRepository;
import ss14_sort.utils.compare.StudentNameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    //   private static int numberPeopleOfCompany =0;
    static {
        students.add(new Student("hai",8,"123"));
        students.add(new Student("hai6",7,"123"));
        students.add(new Student("hai2",9,"123"));
        students.add(new Student("hai7",6,"123"));
        students.add(new Student("hai4",10,"123"));
        students.add(new Student("hai5",5,"123"));
    }
    @Override
    public void saveStudent(Student student) {
        students.add(student);
//        numberPeopleOfCompany++;
    }

    @Override
    public void search(String name) {
        boolean isFind = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNameStudent().equals(name)) {
                System.out.println(students.get(i));
                isFind = true;
            }
        }
        if(!isFind) {
            System.out.println("Không tìm thấy học sinh");
        }
    }

    public void displayAllStudent() {
        Collections.sort(students,new StudentNameComparator());
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
