package ss16_io_text_file.controller;

import ss16_io_text_file.model.Student;
import ss16_io_text_file.service.IStudentService;
import ss16_io_text_file.service.impl.StudentService;

public class StudentController {
    // DI
    private static IStudentService iStudentService = new StudentService();
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }

    public void searchStudent(String name) {
        iStudentService.searchStudent(name);
    }

    public void displayStudents() {
        iStudentService.displayStudent();
    }
}
