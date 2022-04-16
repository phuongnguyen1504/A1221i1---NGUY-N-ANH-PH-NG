package ss10_dsa.controller;

import ss10_dsa.model.Student;
import ss10_dsa.service.IStudentService;
import ss10_dsa.service.impl.StudentService;

public class StudentController {
    // DI
    private static IStudentService iStudentService = new StudentService();
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }
}
