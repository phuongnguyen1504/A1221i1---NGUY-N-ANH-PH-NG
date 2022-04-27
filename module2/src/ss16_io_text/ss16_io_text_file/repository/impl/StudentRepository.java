package ss16_io_text_file.repository.impl;

import ss16_io_text_file.model.Student;
import ss16_io_text_file.repository.IStudentRepository;
import ss16_io_text_file.utils.compare.StudentNameComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    //   private static int numberPeopleOfCompany =0;

    @Override
    public void saveStudent(Student student) {
//        students.add(student);
//        numberPeopleOfCompany++;
        try {
            FileWriter fileWriter = new FileWriter("src/ss16_io_text_file/data/student.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(formatInformationStudent(student));
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void search(String name) {
        boolean isFind = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNameStudent().equals(name)) {
                System.out.println(students.get(i));
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("Không tìm thấy học sinh");
        }
    }

    public void displayAllStudent() {
//        Collections.sort(students,new StudentNameComparator());
//        for (Student student : students) {
//            System.out.println(student);
//        }
        try {
            FileReader fileReader = new FileReader("src/ss16_io_text_file/data/student.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Student student;
            students = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                student = new Student(temp[0], Double.parseDouble(temp[1]), temp[2]);
                students.add(student);
            }
            for(Student student1: students) {
                System.out.println(student1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatInformationStudent(Student student) {
        return student.getNameStudent() + "," + student.getPoint() + "," + student.getDateOfBirth();
    }

}
