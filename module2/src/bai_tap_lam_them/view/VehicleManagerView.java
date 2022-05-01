package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.VehicleController;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Motobike;
import bai_tap_lam_them.model.Truck;

import java.util.Scanner;

import static bai_tap_lam_them.utils.Validate.*;

public class VehicleManagerView {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static String[] input = new String[4];
    private static VehicleController vehicleController = new VehicleController();
    private static String[] listFunction = {"1. Thêm mới phương tiện", "2. Hiện thị phương tiện", "3. Xóa phương tiện", "4. Thoát"};
    private static String[] listVehicle = {"1. Thêm xe tải", "2. Thêm ô tô", "3. Thêm xe máy", "4. Quay lại"};

    private static void displayMainMenu() {
        System.out.println("Vehicle Management Application");
        do {
            for (String li : listFunction) {
                System.out.println(li);
            }
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListVehicle();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No choice");
                }
            } catch (Exception e) {
                System.out.println("Bạn nhập sai rồi. Nhập lại");
            }
        }
        while (choice < 1 || choice > 4);
    }

    private static void displayListVehicle() {
        do {
            try {
                System.out.println("Bạn muốn thêm phương tiện nào");
                for (String li : listVehicle) {
                    System.out.print(li + "\t");
                }
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Thêm xe tải:");
                        input = inputVehicleInfor("TRUCK");
                        System.out.print("Nhập trọng tải:");
                        String weight = scanner.nextLine();
                        vehicleController.addTruck(new Truck(input[0], input[1], input[2], input[3], weight));
                        displayListVehicle();
                    case 2:
                        System.out.println("Thêm ô tô:");
                        input = inputVehicleInfor("CAR");
                        System.out.print("Nhập số chỗ ngồi");
                        String seat = scanner.nextLine();
                        System.out.print("Nhập kiểu xe(du lịch,khách");
                        String type = scanner.nextLine();
                        vehicleController.addCar(new Car(input[0], input[1], input[2], input[3], seat, type));
                        displayListVehicle();
                    case 3:
                        System.out.println("Thêm xe máy:");
                        input = inputVehicleInfor("MOTORBIKE");
                        System.out.print("Nhập công suất:");
                        String power = scanner.nextLine();
                        vehicleController.addMotorbike(new Motobike(input[0], input[1], input[2], input[3], power));
                        displayListVehicle();
                    case 4:
                        displayMainMenu();
                    default:
                        System.out.println("No choice");
                }
            } catch (Exception e) {
                System.out.println("Sai rồi nhập lại đi");
            }
        }
        while (choice < 1 || choice > 4);
    }

    private static String[] inputVehicleInfor(String vehicle) {
        String[] arr = new String[4];
        do {
            try {
                System.out.print("Nhập biển kiểm soát:");
                String plate=scanner.nextLine();
                if(!isExistsPlate(plate,vehicle)){
                    arr[0] = plate;
                    break;
                }
                System.out.println("Biển số trùng rồi");
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        }while (true);
        String brand = "";
        do {
            try {
                System.out.print("Nhập hãng sản xuất:");
                brand = scanner.nextLine();
                if (isExistsBrand(brand)) {
                    arr[1] = brand;
                    break;
                } else {
                    System.out.println("Hãng sản xuất không có trong database. Mời nhập lại");
                    displayExistBrand();
                }
            } catch (Exception e) {
                System.out.println("Không hợp lệ. Mời nhập lại");
            }
        }
        while (true);
        System.out.print("Nhập năm sản xuất:");
        arr[2] = scanner.nextLine();
        System.out.print("Nhập chủ sở hữu:");
        arr[3] = scanner.nextLine();
        return arr;
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
