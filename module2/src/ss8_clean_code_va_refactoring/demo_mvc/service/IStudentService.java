package ss8_clean_code_va_refactoring.demo_mvc.service;

import ss8_clean_code_va_refactoring.demo_mvc.model.Student;

public interface IStudentService {
    void addStudent(Student student);

    void deleteStudent(Student studentDelete);

    void displayStudent();
}
