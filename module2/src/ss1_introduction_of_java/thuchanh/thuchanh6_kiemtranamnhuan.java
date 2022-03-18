package ss1_introduction_of_java.thuchanh;

import java.util.Scanner;

public class thuchanh6_kiemtranamnhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập năm cần kiểm tra:");
        int year = scanner.nextInt();
        /*if (year%4==0){
            if (year%100==0){
                if (year%400==0){
                    System.out.printf("%d là năm nhuận",year);
                }
                else {
                    System.out.printf("%d không phải là năm nhuận",year);
                }
            }
            else {
                System.out.printf("%d là năm nhuận",year);
            }
        }
        else {
            System.out.printf("%d không là năm nhuận",year);
        }*/
        //Cách 2
        /*boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear=true;
            }
        }
        if (isLeapYear){
            System.out.printf("Năm %d là năm nhuận",year);
        }
        else {
            System.out.printf("Năm %d không phải năm nhuận",year);
        }*/
        //cách 3:
        boolean isLeapYear = false;
        boolean isDivisibleBy4=year%4==0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100=year%100==0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400=year%400==0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear=true;
            }
        }
        if (isLeapYear){
            System.out.printf("Năm %d là năm nhuận",year);
        }
        else {
            System.out.printf("Năm %d không phải năm nhuận",year);
        }
    }
}
