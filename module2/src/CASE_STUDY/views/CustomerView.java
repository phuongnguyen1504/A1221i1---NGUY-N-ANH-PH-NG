package CASE_STUDY.views;

import CASE_STUDY.controllers.CustomerController;
import CASE_STUDY.exception.DateOfBirthException.CompareDateOfBirth;
import CASE_STUDY.exception.DateOfBirthException.DayMonthException;
import CASE_STUDY.exception.DateOfBirthException.YearException;
import CASE_STUDY.models.Person.Customer;
import CASE_STUDY.repository.impl.CustomerRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();
    static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static final String[] listCustomerFunction = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};

    public static void displayMainMenu() {
        do {
            System.out.println("Customer Management Application");
            for (String li : listCustomerFunction) {
                System.out.println(li);
            }
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerController.displayCustomers();
                    displayMainMenu();
                    break;
                case 2:
                    Customer customer = inputInformationOfCustomer();
                    customerController.addCustomer(customer);
                    displayMainMenu();
                    break;
                case 3:
                    int index=-1;
                    do{
                        System.out.println("Mời nhập mã KH cần sửa:");
                        String id = scanner.nextLine();
                        index= CustomerRepository.checkId(id);
                        if(index!=-1){
                            Customer editCustomer = inputInformationOfCustomer();
                            customerController.editCustomer(index, editCustomer);
                            break;
                        }
                        else {
                            System.out.println("Không tìm thấy mã khách hàng.Nhập lại.");
                        }
                    }while (true);
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

    private static Customer inputInformationOfCustomer() {
        System.out.println("Mời nhập mã khách hàng");
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
        System.out.println("Chọn loại Khách hàng");
        String type=scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng");
        String address=scanner.nextLine();
        return new Customer(code,name,dateOfBirth,gender,id,tel,email,type,address);
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
