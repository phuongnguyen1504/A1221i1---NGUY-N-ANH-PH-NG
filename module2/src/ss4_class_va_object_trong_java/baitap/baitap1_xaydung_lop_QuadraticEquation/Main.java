package ss4_class_va_object_trong_java.baitap.baitap1_xaydung_lop_QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Chương trình tính nghiệm phương trinh bac 2: ax2+bx+c=0");
        System.out.println("Nhập giá trị a:");
        double a=scanner.nextDouble();
        System.out.println("Nhập giá trị b:");
        double b=scanner.nextDouble();
        System.out.println("Nhập giá trị c:");
        double c=scanner.nextDouble();
        QuadraticEquation quadraticEquation=new QuadraticEquation(a,b,c);
        double delta=quadraticEquation.getDiscriminant();
        if (delta>0){
            System.out.println("Phuong trinh co 2 nghiem phan biet là: x1="+quadraticEquation.getRoot1()+" và x2="+quadraticEquation.getRoot2());
        }
        else if (delta==0){
            System.out.println("Phương trình có nghiệm kép x1=x2="+quadraticEquation.getsquareRoot());
        }
        else {
            System.out.println("Phương trinh vô nghiệm");
        }
    }
}
