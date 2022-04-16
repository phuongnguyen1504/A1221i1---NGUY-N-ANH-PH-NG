package ss10_dsa.service.impl;

import ss10_dsa.model.Student;
import ss10_dsa.repository.IStudentRepository;
import ss10_dsa.repository.impl.StudentRepository;
import ss10_dsa.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }
}
