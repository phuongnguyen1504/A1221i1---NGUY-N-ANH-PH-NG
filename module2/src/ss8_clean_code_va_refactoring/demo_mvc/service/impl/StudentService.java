package ss8_clean_code_va_refactoring.demo_mvc.service.impl;

import ss8_clean_code_va_refactoring.demo_mvc.model.Student;
import ss8_clean_code_va_refactoring.demo_mvc.repository.IStudentRepository;
import ss8_clean_code_va_refactoring.demo_mvc.repository.impl.StudentRepository;
import ss8_clean_code_va_refactoring.demo_mvc.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }
    public void deleteStudent(String studentDelete){
            iStudentRepository.deleteStudent(studentDelete);
    }

    @Override
    public void displayStudent() {
        iStudentRepository.displayStudent();
    }
}
