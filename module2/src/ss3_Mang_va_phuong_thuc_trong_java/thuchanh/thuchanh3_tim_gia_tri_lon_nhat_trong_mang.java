package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class thuchanh3_tim_gia_tri_lon_nhat_trong_mang {
    public static void main(String[] args) {
        int size;
        int array[];
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.print("Nhập kích thước mảng:");
            size=scanner.nextInt();
            if (size>20){
                System.out.println("Kích thước không được quá 20");
            }
        }while (size>20);
        array=new int[size];
        int i=0;
        while (i<array.length){
            System.out.print("Nhập phần tử thứ "+(i+1)+" : ");
            array[i]=scanner.nextInt();
            i++;
        }
        System.out.print("Danh sách khởi tạo: ");
        for (int j=0;j<array.length;j++){
            System.out.print(array[j]+"\t");
        }
        int max=array[0];
        int index=0;
        for (int j=1;j<array.length;j++){
            if (array[j]>max){
                max=array[j];
                index=j;
            }
        }
        System.out.println("\nGiá trị lớn nhất trong mảng là: "+max+" ở vị trí số "+index);
    }
}
