package ss16_io_text_file.repository;

import ss16_io_text_file.model.Student;

public interface IStudentRepository {
    void saveStudent(Student student);

    void search(String name);

    void displayAllStudent();
}
