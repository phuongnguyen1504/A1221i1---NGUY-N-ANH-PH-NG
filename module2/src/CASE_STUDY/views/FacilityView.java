package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.controllers.FacilityController;
import CASE_STUDY.models.Facility.Room;

import java.util.Scanner;

public class FacilityView {
    private static FacilityController facilityController=new FacilityController();
    static Scanner scanner=new Scanner(System.in);
    private static final String[] listFacilityFunction={"1. Display list facility","2. Add new facility","3. Display list facility maintenance","4. Return main menu"};
    private static final String[] listRoomFunction={"1. Add new Villa","2. Add new House","3. Add new Room","4. Back to menu"};
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
                    facilityController.displayFacility();
                    displayMainMenu();
                    break;
                case 2:
                    displayRoomMenu();
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
    public static void displayRoomMenu() {
        do{
            System.out.println("Room Management Application");
            for (String li:listRoomFunction){
                System.out.println(li);
            }
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Mời nhập số lượng căn villa cần thêm");
                    int numberOfVilla= scanner.nextInt();
                    facilityController.addVilla(numberOfVilla);
                    displayRoomMenu();
                    break;
                case 2:
                    System.out.println("Mời nhập số lượng căn house cần thêm");
                    int house= scanner.nextInt();
                    facilityController.addHouse(house);
                    displayRoomMenu();
                    break;
                case 3:
                    System.out.println("Mời nhập số lượng căn room cần thêm");
                    int room= scanner.nextInt();
                    facilityController.addRoom(room);
                    displayRoomMenu();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice");
            }
        }
        while (choice<1||choice>4);
    }
}
