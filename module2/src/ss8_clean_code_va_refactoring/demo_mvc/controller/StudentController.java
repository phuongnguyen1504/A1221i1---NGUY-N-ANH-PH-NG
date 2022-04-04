package ss8_clean_code_va_refactoring.demo_mvc.controller;

import ss8_clean_code_va_refactoring.demo_mvc.model.Student;
import ss8_clean_code_va_refactoring.demo_mvc.service.IStudentService;
import ss8_clean_code_va_refactoring.demo_mvc.service.impl.StudentService;

public class StudentController {
    // DI
    private static IStudentService iStudentService = new StudentService();
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }

    public void deleteStudent(String studentDelete) {
        iStudentService.deleteStudent(studentDelete);
    }

    public void displayStudent() {
        iStudentService.displayStudent();
    }
}
