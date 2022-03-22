package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap2_them_phan_tu_vao_mang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập kích thước mảng:");
        int size=scanner.nextInt();
        int arr[]=new int[size+1];
        for (int i=0;i<size;i++){
            System.out.println("Nhập phần tử thứ:"+(i+1));
            arr[i]=scanner.nextInt();
        }
        System.out.println("Mảng sau khi khởi tạo: ");
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println("độ dài: "+arr.length);
        System.out.println("Nhập giá trị cần thêm vào:");
        int value=scanner.nextInt();
        System.out.println("Nhập vị trí cần thêm vào");
        int index=scanner.nextInt();
        if (index<=-1||index>(size-1)){
            System.out.println("Không thể chèn phần tử vào mảng");
        }
        else {
            for (int i=arr.length-1;i>index;i--){
                arr[i]=arr[i-1];
            }
            arr[index]=value;
            System.out.println("Mảng sau khi chèn là:");
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]+"\t");
            }
        }
    }
}
