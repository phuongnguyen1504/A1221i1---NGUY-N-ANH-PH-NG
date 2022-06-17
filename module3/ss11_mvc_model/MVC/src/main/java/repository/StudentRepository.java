package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Nguyen Van A", 1, 50, "avatar.png"));
        studentList.add(new Student(2,"Nguyen Van B", 0, 0, "avatar_1.jpg"));
        studentList.add(new Student(3,"Nguyen Van C", 2, 80, "avatar_2.png"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void remove(int id) {
        for (Student student: studentList){
            if(student.getId() == id){
                studentList.remove(student);
                break;
            }
        }
    }

    @Override
    public Student findById(int id) {
        return null;
    }
}
