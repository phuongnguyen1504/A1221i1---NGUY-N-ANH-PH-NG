package CASE_STUDY.views;

import CASE_STUDY.controllers.CustomerController;
import CASE_STUDY.models.Person.Customer;

import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController=new CustomerController();
    static Scanner scanner=new Scanner(System.in);
    private static int choice;
    private static final String[] listCustomerFunction={"1. Display list customers","2. Add new customer","3. Edit customer","4. Return main menu"};

    public static void displayMainMenu() {
        do{
            System.out.println("Customer Management Application");
            for (String li:listCustomerFunction){
                System.out.println(li);
            }
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    customerController.displayCustomers();
                    displayMainMenu();
                    break;
                case 2:
                    Customer customer= inputInformationOfCustomer();
                    customerController.addCustomer(customer);
                    displayMainMenu();
                    break;
                case 3:
                    System.out.println("Mời nhập CMND của khách hàng cần sửa:");
                    int id= scanner.nextInt();
                    Customer editCustomer=inputInformationOfCustomer();
                    customerController.editCustomer(id,editCustomer);
                    displayMainMenu();
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }

    private static Customer inputInformationOfCustomer() {
        System.out.println("Mời nhập CMND");
        int id= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mời nhập họ tên");
        String name=scanner.nextLine();
        int age = 0;
        do{
            System.out.println("Nhập tuổi:");
            age = Integer.parseInt(scanner.nextLine());
            if (age<1){
                System.out.println("Mời nhập lại tuổi");
            }
        }
        while (age<1);
        System.out.println("Nhập giới tính");
        String gender=scanner.nextLine();
        return new Customer(id,name,age,gender);
    }
}
