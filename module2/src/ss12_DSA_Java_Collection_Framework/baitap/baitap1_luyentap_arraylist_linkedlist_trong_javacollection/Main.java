package ss12_DSA_Java_Collection_Framework.baitap.baitap1_luyentap_arraylist_linkedlist_trong_javacollection;

import ss8_clean_code_va_refactoring.test_mvc.model.Student;

import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    private static ProductManager productManager=new ProductManager();
    public static void main(String[] args) {
        productManager.add(new Product(12,"dao",100));
        productManager.add(new Product(23,"kéo",200));
        productManager.add(new Product(34,"búa",500));
        productManager.add(new Product(56,"bao",300));
        System.out.println("Chương trình quản lý sản phẩm:");
        while (true){
            System.out.println("1.Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo Id");
            System.out.println("3. Xoá sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.println("7. Exit");
            int choice= Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManager.add(addProduct());
                    break;
                case 2:
                    System.out.println("Mời bạn nhập Id sản phẩm cần sửa");
                    int id = getId();
                    productManager.replace(id,addProduct());
                    break;
                case 3:
                    System.out.println("Mời bạn nhập Id sản phẩm cần xóa:");
                    productManager.delete(getId());
                    break;
                case 4:
                    productManager.displayProduct();
                    break;
                case 5:
                    System.out.println("Mời bạn nhập tên sản phẩm cần tìm:");
                    String name=scanner.nextLine();
                    productManager.findProductByName(name);
                    break;
                case 6:
                    System.out.println("Bạn muốn lọc theo giá tăng dần hay giảm dần:\n1. Tăng dần\n2.Giảm dần");
                    int select=0;
                    do{
                        select= Integer.parseInt(scanner.nextLine());
                    }
                    while (select>2||select<1);
                    System.out.println("hellpo");
                    productManager.sort(select);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static int getId() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static Product addProduct() {
        System.out.println("Mời bạn nhập thông tin sản phẩm:");
        System.out.println("Mời nhập id");
        int id= Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập tên sản phẩm:");
        String name=scanner.nextLine();
        System.out.println("Mời nhập giá sản phẩm:");
        int price=Integer.parseInt(scanner.nextLine());
        return new Product(id,name,price);
    }
}
