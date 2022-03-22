package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap1_xoa_phan_tu_khoi_mang {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Nhập kích thước mảng phần tử:");
        int size=input.nextInt();
        int[] arr=new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập phần tử thứ "+(i+1));
            arr[i]=input.nextInt();
        }
        System.out.print("Danh sách khởi tạo: ");
        for (int j=0;j<arr.length;j++){
            System.out.print(arr[j]+"\t");
        }
        System.out.println("\nNhập phần từ cần xóa:");
        int searchValue=input.nextInt();
        int index=-1;
        for (int i=0;i<size;i++){
            if (arr[i]==searchValue){
                index=i;
            }
        }
        if (index!=-1){
            for (int i=index;i<size-1;i++){
                arr[i]=arr[i+1];
            }
            System.out.println("Danh sách sau khi xóa phần tử: ");
            for (int j=0;j<arr.length-1;j++){
                System.out.print(arr[j]+"\t");
            }
        }
        else {
            System.out.print("Không có "+searchValue+" ở trong mảng. Mảng không thay đổi "+"\t");
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[j]+"\t");
            }
        }
    }
}
