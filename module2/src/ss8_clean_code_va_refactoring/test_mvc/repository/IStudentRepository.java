package ss8_clean_code_va_refactoring.test_mvc.repository;

import ss8_clean_code_va_refactoring.test_mvc.model.Student;

public interface IStudentRepository {
    void saveStudent(Student student);

    void displayStudent();

    void deleteStudent(String studentDelete);
}
