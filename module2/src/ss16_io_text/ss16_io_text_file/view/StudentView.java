package ss16_io_text_file.view;

import ss16_io_text_file.controller.StudentController;
import ss16_io_text_file.model.Student;

import java.util.Scanner;

public class StudentView {
    static Scanner scanner = new Scanner(System.in);
    private static StudentController studentController = new StudentController();

    public static void main(String[] args) {
        System.out.println("Chào mừng bạn đến với trang web quản lí học sinh");
        while (true) {
            System.out.println("1.Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Tìm kiếm học sinh");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentController.displayStudents();
                    break;
                case 2:
                    Student student = inputInformationOfStudent();
                    studentController.addStudent(student);
                    break;
                case 3:
                    System.out.println("Mời bạn nhập tên học sinh cần tìm: ");
                    String name = scanner.nextLine();
                    studentController.searchStudent(name);
            }
        }
    }

    private static Student inputInformationOfStudent() {
        System.out.print("Mời bạn nhập tên của học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double point;
        do {
            try {
                point = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Người dùng nhập sai định dạng");
                System.out.print("yêu cầu nhập lại: ");
            } catch (Exception e) {
                System.out.println("Lỗi. Nhập lại.");
            }
        } while (true);


        System.out.print("Mời bạn nhập ngày tháng năm sinh của học sinh: ");
        String dateOfBirth = scanner.nextLine();
        Student student = new Student(name, point, dateOfBirth);
        return student;
    }
}
