package ss8_clean_code_va_refactoring.demo_mvc.repository;

import ss8_clean_code_va_refactoring.demo_mvc.model.Student;

public interface IStudentRepository {
    void saveStudent(Student student);

    void deleteStudent(String student);

    void displayStudent();
}
