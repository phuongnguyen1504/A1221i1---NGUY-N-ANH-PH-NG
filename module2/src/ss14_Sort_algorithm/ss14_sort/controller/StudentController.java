package ss14_sort.controller;

import ss14_sort.model.Student;
import ss14_sort.service.IStudentService;
import ss14_sort.service.impl.StudentService;

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
