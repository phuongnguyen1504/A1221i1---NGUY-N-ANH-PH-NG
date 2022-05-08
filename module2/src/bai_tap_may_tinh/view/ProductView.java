package bai_tap_may_tinh.view;

import bai_tap_may_tinh.controller.ProductController;

import java.util.Scanner;

public class ProductView {
    private static Scanner scanner=new Scanner(System.in);
    private static int choice;
    private static ProductController productController=new ProductController();
    private static final String[] function={"1. Thêm mới","2. Xóa","3. Xem","4. Tìm kiếm","5. Thoát"};
    private static final String[] typeOfProduct={"1. Chính hãng","2. Xách tay","3. Trở về"};
    public static void displayMenu(){
        do {
            try {
                System.out.println("Chương trình quản lý sản phẩm");
                for (String li:function){
                    System.out.println(li);
                }
                choice= Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        displayTypeProduct();
                        displayMenu();
                    case 2:
                        productController.delete();
                        displayMenu();
                    case 3:
                        productController.display();
                        displayMenu();
                    case 4:
                        displayMenu();
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("No choice. Try again");
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }while (choice<1||choice>5);
    }
    public static void displayTypeProduct(){
        do{
            try{
                System.out.println("Chọn loại sản phẩm cần thêm:");
                for (String li:typeOfProduct){
                    System.out.println(li);
                }
                choice= Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        productController.add("CHINHHANG");
                        break;
                    case 2:
                        productController.add("XACHTAY");
                        break;
                    case 3:
                        displayMenu();
                    default:
                        System.out.println("No choice. Try again");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice<1||choice>3);
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
