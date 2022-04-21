package ss14_sort.service.impl;

import ss14_sort.model.Student;
import ss14_sort.repository.IStudentRepository;
import ss14_sort.repository.impl.StudentRepository;
import ss14_sort.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }

    @Override
    public void searchStudent(String name) {
        iStudentRepository.search(name);
    }

    @Override
    public void displayStudent() {
        iStudentRepository.displayAllStudent();
    }
}
