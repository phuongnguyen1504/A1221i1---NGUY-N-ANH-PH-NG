package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void save(Student student);
    void remove(int id);
    Student findById(int id);
}
