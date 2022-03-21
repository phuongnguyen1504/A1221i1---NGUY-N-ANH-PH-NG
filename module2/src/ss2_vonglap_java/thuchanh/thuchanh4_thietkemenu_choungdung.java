package ss2_vonglap_java.thuchanh;

import java.util.Scanner;

public class thuchanh4_thietkemenu_choungdung {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice!=0) {
            System.out.println("Menu");
            System.out.println("1.Vẽ tam giác");
            System.out.println("2.Vẽ hình vuông");
            System.out.println("3.Vẽ hình chữ nhật");
            System.out.println("0.Thoát chương trình");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Vẽ hình tam giác");
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("Vẽ hình vuông");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 3:
                    System.out.println("Vẽ hình chữ nhật");
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
