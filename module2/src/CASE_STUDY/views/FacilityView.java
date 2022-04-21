package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.controllers.FacilityController;

import java.util.Scanner;

public class FacilityView {
    private static FacilityController facilityController=new FacilityController();
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listFacilityFunction={"1. Display list facility","2. Add new facility","3. Display list facility maintenance","4. Return main menu"};
    private static int choice;
    public static void displayMainMenu() {
        do{
            System.out.println("Facility Management Application");
            for (String li:listFacilityFunction){
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
