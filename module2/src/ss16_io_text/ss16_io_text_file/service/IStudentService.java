package ss16_io_text_file.service;

import ss16_io_text_file.model.Student;

public interface IStudentService {
    void addStudent(Student student);

    void searchStudent(String name);

    void displayStudent();
}
