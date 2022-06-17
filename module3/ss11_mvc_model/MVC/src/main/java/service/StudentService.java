package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.remove(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
