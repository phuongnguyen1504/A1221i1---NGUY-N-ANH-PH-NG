package ss1_introduction_of_java.baitap;

import java.util.Scanner;

public class baitap3_chuyendoitiente {
    public static void main(String[] args) {
        final int rate=23000;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your USD amount to convert to VND:");
        int amount=scanner.nextInt();
        int result=rate*amount;
        System.out.println(amount+" USD sau khi chuyen sang VND la: "+result+" VND");
    }
}
