package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap5_tim_gia_tri_nho_nhat_trong_mang {
    public static int minValue(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int size=scanner.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập phần tử thứ "+(i+1));
            arr[i]=scanner.nextInt();
        }
        System.out.println("Mảng sau khi khởi tạo: ");
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+"\t");
        }
        int index=minValue(arr);
        System.out.println("Giá trị nhỏ nhất của mảng là "+arr[index]);
    }
}
