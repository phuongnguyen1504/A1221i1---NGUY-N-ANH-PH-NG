package ss2_vonglap_java.thuchanh;

import java.util.Scanner;

public class thuchanh3_uoc_chung_lon_nhat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a:");
        int a=sc.nextInt();
        System.out.println("Enter b:");
        int b=sc.nextInt();
        a=Math.abs(a);
        b=Math.abs(b);
        if (a==0&&b==0){
            System.out.println("hai số không có ước chung lớn nhất");
        }
        else if (a==0){
            System.out.println("UCLN của a và b là: "+b);
        }
        else if (b==0){
            System.out.println("UCLN của a và b là: "+a);
        }
        else {
            while (a!=b){
                
            }
        }
    }
}
