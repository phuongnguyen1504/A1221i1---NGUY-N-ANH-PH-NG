package ss1_introduction_of_java.thuchanh;

import java.util.Scanner;

public class thuchanh5_songaytrongthang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tháng cần đếm ngày:");
        int month = scanner.nextInt();
        /*switch (month){
            case 2:
                System.out.print("Tháng 2 có 28 hoặc 29 ngày");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("Tháng "+month+ " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("Tháng "+month+ " có 30 ngày");
                break;
            default:
                System.out.print("Tháng nhập vào không hợp lệ");*/
        String daysInMonth;
        switch (month) {
            case 2:
                daysInMonth="28 hoặc 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth="31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth="30";
                break;
            default:
                daysInMonth="";
        }
        if (!daysInMonth.equals("")) {
            System.out.printf("Tháng %d có %s ngày",month,daysInMonth);
        }
        else {
            System.out.print("Không hợp lệ!");
        }
    }
}
