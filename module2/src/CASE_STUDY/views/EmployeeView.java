package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.repository.impl.EmployeeRepository;

import java.util.Scanner;

public class EmployeeView {
    private static EmployeeController employeeController=new EmployeeController();
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listEmployeeManage={"1. Display list employees","2. Add new employee","3. Edit employee","4. Return main menu"};
    private static int choice;
    private static EmployeeController employeeRepository=
    public static void displayMainMenu() {
        do{
            System.out.println("Employee Management Application");
            for (String li:listEmployeeManage){
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
