package ss1_introduction_of_java.baitap;

import java.util.Scanner;

public class baitap1_hienthiloichao {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("Your name is: "+name);
    }
}
