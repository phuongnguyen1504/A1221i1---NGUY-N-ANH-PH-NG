package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class thuchanh1_dao_nguoc_cac_phantu_cua_mang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.print("Nhập vào kích thước mảng:");
            size=scanner.nextInt();
            if (size>20){
                System.out.println("Kích thước tối đa chỉ được 20 mà thôi!");
            }
        }
        while (size<20);
        array =new int[20];
        int i=0;
        while (i<array.length){
            System.out.print("Nhập phần tử thứ "+(i+1)+": ");
            array[i]=scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "Các phần tử trong mảng: ", "");
        for (int j=0;j<array.length;j++){
            System.out.print(array[j]+"\t");
        }
        for (int j=0;j<array.length/2;j++){
            int temp=array[j];
            array[j]=array[size-1-j];
            array[size-1-j]=temp;
        }
        System.out.printf("\n%-20s%s","Mảng đảo ngược là: ","");
        for (int j=0;j<array.length;j++){
            System.out.print(array[j]+"\t");
        }
    }
}
