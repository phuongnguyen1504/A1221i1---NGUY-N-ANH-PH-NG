package ss14_sort.service;

import ss14_sort.model.Student;

public interface IStudentService {
    void addStudent(Student student);

    void searchStudent(String name);

    void displayStudent();
}
