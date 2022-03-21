package ss2_vonglap_java.baitap;

import java.util.Scanner;

public class baitap1_hienthicacloaihinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1.Vẽ hình chữ nhật");
            System.out.println("2.Vẽ hình tam giác vuông");
            System.out.println("3.Vẽ hình tam giác cân");
            System.out.println("0.Thoát chương trình");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vẽ hình chữ nhật");
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 2:
                    System.out.println("Vẽ hình tam giác vuông dưới cùng trái");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                            if (j<=i){
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ hình tam giác vuông trên cùng bên phải");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                            if (j>=i){
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ hình tam giác vuông trên cùng bên trái");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                            if (j<=4-i){
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Vẽ hình tam giác vuông dưới cùng bên phải");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<5;j++){
                            if (j<4-i){
                                System.out.print(" ");
                            }
                            else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Vẽ hình tam giác cân");
                    for (int i=0;i<5;i++){
                        for (int j=0;j<9;j++){
                            if (j<4-i||j>4+i){
                                System.out.print(" ");
                            }
                            else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
