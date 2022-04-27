package ss16_io_text_file.service.impl;

import ss16_io_text_file.model.Student;
import ss16_io_text_file.repository.IStudentRepository;
import ss16_io_text_file.repository.impl.StudentRepository;
import ss16_io_text_file.service.IStudentService;
import ss16_io_text_file.utils.exception.CheckPointStudentException;

import java.util.Scanner;

public class StudentService implements IStudentService {
    private static IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public void addStudent(Student student) {
        do {
            if (student.getPoint() < 0) {
                try {
                    throw new CheckPointStudentException("Điểm không được nhỏ hơn 0");
                } catch (CheckPointStudentException e) {
                    System.out.println(e.getMessage());
                    student.setPoint(Double.parseDouble(new Scanner(System.in).nextLine()));
                }
            } else {
                break;
            }
        }
        while (true);
        iStudentRepository.saveStudent(student);
    }

    @Override
    public void searchStudent(String name) {
        iStudentRepository.search(name);
    }

    @Override
    public void displayStudent() {
        iStudentRepository.displayAllStudent();
    }
}
