package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        addTwoNumber();
    }
    public static void addTwoNumber(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mời bạn nhập số thứ nhất: ");
        int numberOne=Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập số thứ hai: ");
        int numberTwo=Integer.parseInt(scanner.nextLine());
        int result=numberOne+numberTwo;
        System.out.println("Kết quả của phép tính là: "+result);
    }
}
