package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class thuchanh6_ung_dung_dem_soluong_sinh_vien_thi_do {
    public static void main(String[] args) {
        int size;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Nhập kích thước mảng:");
            size= scanner.nextInt();
            if (size>30){
                System.out.println("Kích thước không được quá 30");
            }
        }while (size>30);
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Nhập điểm sinh viên thứ "+(i+1));
            arr[i]=scanner.nextInt();
        }
        int dem=0;
        System.out.println("List điểm của học sinh là: ");
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+"\t");
            if (arr[i]>=5){
                dem++;
            }
        }
        System.out.println("\nSố lượng sinh viên đậu là: "+dem);
    }
}
