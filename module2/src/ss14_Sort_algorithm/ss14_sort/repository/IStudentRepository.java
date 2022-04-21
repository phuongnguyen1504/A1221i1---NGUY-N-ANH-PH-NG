package ss14_sort.repository;

import ss14_sort.model.Student;

public interface IStudentRepository {
    void saveStudent(Student student);

    void search(String name);

    void displayAllStudent();
}
