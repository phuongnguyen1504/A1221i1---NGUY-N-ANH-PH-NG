package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.exception.DateOfBirthException.CompareDateOfBirth;
import CASE_STUDY.exception.DateOfBirthException.DayMonthException;
import CASE_STUDY.exception.DateOfBirthException.YearException;
import CASE_STUDY.models.Person.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();
    static Scanner scanner = new Scanner(System.in);
    private static final String[] listEmployeeManage = {"1. Display list employees", "2. Add new employee", "3. Edit employee", "4. Return main menu"};
    private static int choice;

    public static void displayMainMenu() {
        do {
            System.out.println("Employee Management Application");
            for (String li : listEmployeeManage) {
                System.out.println(li);
            }
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeController.displayEmployees();
                    displayMainMenu();
                    break;
                case 2:
                    Employee employee = inputEmployee();
                    employeeController.addEmployee(employee);
                    System.out.println("đã thêm nhân viên thành công");
                    displayMainMenu();
                    break;
                case 3:
                    System.out.println("Mời nhập id nhân viên cần sửa");
                    int id= Integer.parseInt(scanner.nextLine());
                    Employee employee1=inputEmployee();
                    employeeController.editEmployee(id,employee1);
                    displayMainMenu();
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice < 1 || choice > 4);

    }

    private static Employee inputEmployee() {
        System.out.println("Mời nhập CMND nhân viên");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập tên nhân viên");
        String name = scanner.nextLine();
        String dateOfBirth = null;
        do {
            try{
                dateOfBirth=inputDateOfBirth();
                int day=Integer.parseInt(dateOfBirth.split("/")[0]);
                int month=Integer.parseInt(dateOfBirth.split("/")[1]);
                int year = Integer.parseInt(dateOfBirth.split("/")[2]);
                int currentYear = getCurrentYear();
                new CompareDateOfBirth(day,month,year,currentYear);
                break;
            }
            catch (YearException e){
                System.out.println(e.getMessage());
                displayMainMenu();
            }
            catch (DayMonthException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Sai rồi nhập lại đi");
            }
        } while (true);
        System.out.println("Mời nhập giới tính");
        String gender = scanner.nextLine();
        return new Employee(id, name, dateOfBirth, gender);
    }

    private static int getCurrentYear() {
        LocalDate localDate = LocalDate.now();
        int currentYear = localDate.getYear();
        return currentYear;
    }

    private static String inputDateOfBirth(){
        System.out.println("Mời nhập ngày sinh theo định dạng DD/MM/Year");
        return scanner.nextLine();
    }
}
