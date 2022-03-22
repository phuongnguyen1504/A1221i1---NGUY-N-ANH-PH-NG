package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap3_gop_mang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập kích thước mảng 1:");
        int size1=scanner.nextInt();
        int arr1[]=new int[size1];
        for (int i=0;i<size1;i++){
            System.out.println("Nhập phần tử mảng 1 thứ: "+(i+1));
            arr1[i]=scanner.nextInt();
        }
        System.out.println("Mảng 1 sau khi khởi tạo:");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+"\t");
        }
        System.out.println("\nNhập kích thước mảng 2:");
        int size2=scanner.nextInt();
        int arr2[]=new int[size2];
        for (int i=0;i<size2;i++){
            System.out.println("Nhập phần tử mảng 2 thứ: "+(i+1));
            arr2[i]=scanner.nextInt();
        }
        System.out.println("Mảng 2 sau khi khởi tạo:");
        for (int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+"\t");
        }
        int arr3[]=new int[size1+size2];
        System.out.println("\nMảng 3 sau khi gộp mảng 1 và 2:");
        for(int i=0;i<arr1.length;i++){
            arr3[i]=arr1[i];
        }
        for (int i=arr1.length;i< arr3.length;i++){
            arr3[i]=arr2[i-arr1.length];
        }
        for (int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+"\t");
        }
    }
}
