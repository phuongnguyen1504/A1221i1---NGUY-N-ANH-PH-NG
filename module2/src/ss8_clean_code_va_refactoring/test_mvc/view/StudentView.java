package ss8_clean_code_va_refactoring.test_mvc.view;

import ss8_clean_code_va_refactoring.test_mvc.controller.StudentController;
import ss8_clean_code_va_refactoring.test_mvc.model.Student;

import java.util.Scanner;

public class StudentView {
    static Scanner scanner=new Scanner(System.in);
    private static StudentController studentController=new StudentController();

    public static void main(String[] args) {
        System.out.println("Chào mừng bạn đến với trang web quản lí học sinh");
        while (true){
            System.out.println("1.Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Kết thúc chương trình");
            int choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentController.displayListOfStudent();
                    break;
                case 2:
                    Student student= getInformationOfStudent();
                    studentController.addStudent(student);
                    break;
                case 3:
                    String studentDelete= getInputStudentDelete();
                    studentController.deleteStudent(studentDelete);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static String getInputStudentDelete() {
        System.out.println("Mời nhập tên sinh viên cần xóa:");
        String studentDelete=scanner.nextLine();
        return studentDelete;
    }

    private static Student getInformationOfStudent() {
        System.out.print("Mời bạn nhập tên của học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập ngày tháng năm sinh của học sinh: ");
        String dateOfBirth = scanner.nextLine();
        Student student=new Student(name,point,dateOfBirth);
        return student;
    }

}
