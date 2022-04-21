package CASE_STUDY.views;

import CASE_STUDY.controllers.CustomerController;

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
                    break;
                case 2:
                    break;
                case 3:
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
}
