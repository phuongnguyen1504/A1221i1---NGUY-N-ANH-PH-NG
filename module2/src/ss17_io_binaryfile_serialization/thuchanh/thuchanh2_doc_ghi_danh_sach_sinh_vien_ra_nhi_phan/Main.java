package ss17_io_binaryfile_serialization.thuchanh.thuchanh2_doc_ghi_danh_sach_sinh_vien_ra_nhi_phan;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> students){
        try {
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            students= (List<Student>) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        String path="src/ss17_io_binaryfile_serialization/thuchanh/thuchanh2_doc_ghi_danh_sach_sinh_vien_ra_nhi_phan/student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile(path,students);
        List<Student> studentsDataFromFile=readDataFromFile(path);
        for (Student student:studentsDataFromFile){
            System.out.println(student);
        }
    }
}
