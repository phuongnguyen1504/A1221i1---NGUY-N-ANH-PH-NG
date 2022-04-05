package ss8_clean_code_va_refactoring.test_mvc.controller;

import ss8_clean_code_va_refactoring.test_mvc.model.Student;
import ss8_clean_code_va_refactoring.test_mvc.service.impl.StudentService;

public class StudentController {
    private StudentService studentService=new StudentService();
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    public void displayListOfStudent() {
        studentService.displayStudent();
    }

    public void deleteStudent(String studentDelete) {
        studentService.deleteStudent(studentDelete);
    }
}
