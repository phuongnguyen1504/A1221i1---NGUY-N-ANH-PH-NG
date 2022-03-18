package ss2_vonglap_java.thuchanh;

import java.util.Scanner;

public class thuchanh1_kiemtrasonguyento {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your number:");
        int number=sc.nextInt();
        boolean flag=true;
        if (number<2){
            flag=false;
        }
        else if (number>2){
            for (int i=2;i<Math.sqrt(number);i++){
                if (number%i==0){
                    flag=false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println(number+" là số nguyên tố");
        }
        else {
            System.out.println(number+" không là số nguyên tố");
        }

    }
}
