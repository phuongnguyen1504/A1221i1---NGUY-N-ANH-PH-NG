package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.exception.DateOfBirthException.CompareDateOfBirth;
import CASE_STUDY.exception.DateOfBirthException.DayMonthException;
import CASE_STUDY.exception.DateOfBirthException.YearException;
import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.models.Person.Employee;
import CASE_STUDY.repository.impl.CustomerRepository;
import CASE_STUDY.repository.impl.EmployeeRepository;

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
                    int index=-1;
                    do{
                        System.out.println("Mời nhập mã nhân viên cần sửa:");
                        String id = scanner.nextLine();
                        index= EmployeeRepository.checkId(id);
                        if(index!=-1){
                            Employee editEmployee = inputEmployee();
                            employeeController.editEmployee(index, editEmployee);
                            break;
                        }
                        else {
                            System.out.println("Không tìm thấy mã nhân viên.Nhập lại.");
                        }
                    }while (true);
                    displayMainMenu();
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
        System.out.println("Mời nhập mã nhân viên");
        String code=scanner.nextLine();
        System.out.println("Mời nhập họ tên");
        String name=scanner.nextLine();
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
        System.out.println("Mời nhập CMND");
        int id= Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập SĐT");
        int tel= Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập email");
        String email=scanner.nextLine();
        System.out.println("Nhập trình độ nhân viên");
        String level=scanner.nextLine();
        System.out.println("Nhập chức vụ nhân viên");
        String position=scanner.nextLine();
        System.out.println("Mời nhập tiền lương");
        int salary= Integer.parseInt(scanner.nextLine());
        return new Employee(code,name,dateOfBirth,gender,id,tel,email,level,position,salary);
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
