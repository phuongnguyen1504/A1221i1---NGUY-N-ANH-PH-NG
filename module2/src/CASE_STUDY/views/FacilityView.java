package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.controllers.FacilityController;
import CASE_STUDY.models.Facility.Room;

import java.util.Scanner;

public class FacilityView {
    private static FacilityController facilityController=new FacilityController();
    /*public  static  Scanner input(){
        return new Scanner(System.in);
    }*/
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
                    System.out.println("Mời nhập thông tin dịch vụ Villa");
                    System.out.println("Mời nhập loại Dịch vụ");
                    String nameService=scanner.nextLine();
                    System.out.println("Mời nhập diện tích");
                    int square= Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời nhập tiền thuê nhà");
                    int cost=Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời nhập số lượng người ở tối đa");
                    int maxPeople=Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời nhập kiểu thuê theo năm,tháng,ngày, giờ");
                    String type=scanner.nextLine();
                    System.out.println("Mời nhập tiêu chuẩn của phòng");
                    String standard= scanner.nextLine();
                    System.out.println("Mời nhập diện tích hồ bơi");
                    String squarePool=scanner.nextLine();
                    System.out.println("Mời nhập số tầng");
                    int numFloor= Integer.parseInt(scanner.nextLine());

                    //facilityController.addVilla(numberOfVilla);
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
