package CASE_STUDY.views;

import CASE_STUDY.controllers.EmployeeController;
import CASE_STUDY.controllers.FacilityController;
import CASE_STUDY.models.Facility.Facility;
import CASE_STUDY.models.Facility.House;
import CASE_STUDY.models.Facility.Room;
import CASE_STUDY.models.Facility.Villa;

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
            choice= Integer.parseInt(scanner.nextLine());
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
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Facility villa= inputVillaInfor();
                    System.out.println("Thông tin: "+villa);
                    facilityController.addVilla(villa);
                    displayRoomMenu();
                    break;
                case 2:
                    Facility house= inputHouseInfor();
                    System.out.println(house);
                    facilityController.addHouse(house);
                    displayRoomMenu();
                    break;
                case 3:
                    Facility room= inputRoomInfor();
                    System.out.println(room);
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

    private static Room inputRoomInfor() {
        System.out.println("Mời nhập thông tin dịch vụ Room");
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
        System.out.println("Nhập dịch vụ đi kèm miễn phí");
        String freeService=scanner.nextLine();
        return new Room(nameService,square,cost,maxPeople,type,freeService);
    }

    private static House inputHouseInfor() {
        System.out.println("Mời nhập thông tin dịch vụ House");
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
        System.out.println("Mời nhập tiêu chuẩn phòng");
        String roomStandard=scanner.nextLine();
        System.out.println("Mời nhập số tầng");
        int numFloor= Integer.parseInt(scanner.nextLine());
        return new House(nameService,square,cost,maxPeople,type,roomStandard,numFloor);
    }

    private static Villa inputVillaInfor() {
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
        return new Villa(nameService,square,cost,maxPeople,type,standard,squarePool,numFloor);
    }
}
