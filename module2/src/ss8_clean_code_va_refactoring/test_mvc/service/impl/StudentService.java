package ss8_clean_code_va_refactoring.test_mvc.service.impl;

import ss8_clean_code_va_refactoring.test_mvc.model.Student;
import ss8_clean_code_va_refactoring.test_mvc.repository.IStudentRepository;
import ss8_clean_code_va_refactoring.test_mvc.repository.impl.StudentRepository;
import ss8_clean_code_va_refactoring.test_mvc.service.IStudentService;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository=new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if (student.getPoint()<5){
            System.out.println("Không đủ điểm. Bạn đã rớt");
        }
        else {
            iStudentRepository.saveStudent(student);
        }
    }

    public void displayStudent() {
        iStudentRepository.displayStudent();
    }

    public void deleteStudent(String studentDelete) {
        iStudentRepository.deleteStudent(studentDelete);
    }
}
