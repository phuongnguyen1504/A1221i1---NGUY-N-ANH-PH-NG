package ss8_clean_code_va_refactoring.thuchanh.thuchanh3_tach_phuong_thuc;

import java.util.Scanner;

import static ss8_clean_code_va_refactoring.thuchanh.thuchanh3_tach_phuong_thuc.Cylinder.getVolume;

public class CylinderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Mời nhập bán kình vào:");
            int radius = Integer.parseInt(scanner.nextLine());
            System.out.println("Mời nhập chiều cao vào:");
            int height = Integer.parseInt(scanner.nextLine());
            System.out.println(getVolume(radius, height));
        }
    }
}
