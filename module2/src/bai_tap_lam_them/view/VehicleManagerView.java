package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.VehicleController;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Motobike;
import bai_tap_lam_them.model.Truck;
import bai_tap_lam_them.utils.CheckPlate;
import bai_tap_lam_them.utils.PlateException;


import java.util.Scanner;

import static bai_tap_lam_them.utils.Validate.*;

public class VehicleManagerView {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static String[] input = new String[4];
    private static VehicleController vehicleController = new VehicleController();
    private static String[] listFunction = {"1. Thêm mới phương tiện", "2. Hiện thị phương tiện", "3. Xóa phương tiện", "4. Thoát"};
    private static String[] listVehicleToAdd = {"1. Thêm xe tải", "2. Thêm ô tô", "3. Thêm xe máy", "4. Quay lại"};
    private static String[] listDisplayVehicle = {"1. Hiện thị xe tải.", "2. Hiện thị ôtô.", "3. Hiện  xe máy.", "4. Trở về"};

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
                        displayListAddVehicle();
                        break;
                    case 2:
                        displayVehicle();
                        break;
                    case 3:
                        deleteVehicle();
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

    private static void deleteVehicle() throws PlateException {
        System.out.println("Xóa phương tiện");
        String plate = "";
        do {
            System.out.print("Nhập biển số cần xóa:");
            plate = scanner.nextLine();
            if (plate.equals("")) {
                System.out.println("Quay về màn hình chính!");
                displayMainMenu();
            }
            try {
                new CheckPlate(plate);
                if (isExistsPlate(plate, "TRUCK")) {
                    vehicleController.delete(plate, "TRUCK");
                    displayMainMenu();
                } else if (isExistsPlate(plate, "CAR")) {
                    vehicleController.delete(plate, "CAR");
                    displayMainMenu();
                } else if (isExistsPlate(plate, "MOTORBIKE")) {
                    vehicleController.delete(plate, "MOTORBIKE");
                    displayMainMenu();
                }
            } catch (PlateException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static void displayVehicle() {
        do {
            try {
                System.out.println("Bạn muốn hiển thị phương tiện nào:");
                for (String li : listDisplayVehicle) {
                    System.out.print(li + "\t");
                }
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        vehicleController.displayVehicle("TRUCK");
                        displayMainMenu();
                    case 2:
                        vehicleController.displayVehicle("CAR");
                        displayMainMenu();
                    case 3:
                        vehicleController.displayVehicle("MOTORBIKE");
                        displayMainMenu();
                    case 4:
                        displayMainMenu();
                    default:
                        System.out.print("No choice");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại đi");
            }
        } while (true);
    }

    private static void displayListAddVehicle() {
        do {
            try {
                System.out.println("Bạn muốn thêm phương tiện nào");
                for (String li : listVehicleToAdd) {
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
                        displayListAddVehicle();
                    case 2:
                        System.out.println("Thêm ô tô:");
                        input = inputVehicleInfor("CAR");
                        System.out.print("Nhập số chỗ ngồi");
                        String seat = scanner.nextLine();
                        vehicleController.addCar(new Car(input[0], input[1], input[2], input[3], seat, input[4]));
                        displayListAddVehicle();
                    case 3:
                        System.out.println("Thêm xe máy:");
                        input = inputVehicleInfor("MOTORBIKE");
                        System.out.print("Nhập công suất:");
                        String power = scanner.nextLine();
                        vehicleController.addMotorbike(new Motobike(input[0], input[1], input[2], input[3], power));
                        displayListAddVehicle();
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
        String[] arr = new String[5];
        String typeOfCar = "";
        String plate = "";
        if (vehicle.equals("CAR")) {
            typeOfCar = inputTypeOfCar();
        }
        do {
            try {
                System.out.print("Nhập biển kiểm soát:");
                plate = scanner.nextLine();
                if (validatePlate(plate, vehicle, typeOfCar)) {
                    if (!isExistsPlate(plate, vehicle)) {
                        arr[0] = plate;
                        break;
                    } else {
                        System.out.println("Biển số trùng rồi");
                    }
                } else {
                    System.out.println("Biển số không hợp lệ");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        } while (true);
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
        String year;
        do {
            try {
                System.out.print("Nhập năm sản xuất:");
                year = scanner.nextLine();
                if (isExistsYear(year)) {
                    arr[2] = year;
                    break;
                } else {
                    System.out.println("Năm sản xuất không hợp lệ");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại năm sản xuất");
            }
        } while (true);
        System.out.print("Nhập chủ sở hữu:");
        arr[3] = scanner.nextLine();
        arr[4] = typeOfCar;
        return arr;
    }

    private static String inputTypeOfCar() {
        do {
            try {
                System.out.print("Nhập kiểu xe. Chọn 1 hoặc 2(1. Du lịch,2. Xe Khách:");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Du lịch";
                    case 2:
                        return "Xe khách";
                    default:
                        System.out.println("No choice");
                }
            } catch (Exception e) {
                System.out.println("Nhập lại đi");
            }

        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
