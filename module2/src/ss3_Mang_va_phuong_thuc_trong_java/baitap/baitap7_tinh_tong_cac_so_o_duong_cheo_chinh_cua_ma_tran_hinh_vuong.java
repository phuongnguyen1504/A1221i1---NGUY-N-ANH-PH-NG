package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap7_tinh_tong_cac_so_o_duong_cheo_chinh_cua_ma_tran_hinh_vuong {
    //tính tổng giá trị của đường chéo số hàng=số cột(i==j)
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[][]=createArray();
        displayArr(arr);
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i][i];
        }
        System.out.println("Tổng các số ở đường chéo chính ma trận hình vuông là: "+sum);
    }
    public static int[][] createArray(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mời nhập số hàng or cột của ma trận hình vuông:");
        int rowcol=scanner.nextInt();
        int arr[][]=new int[rowcol][rowcol];
        for (int i=0;i<rowcol;i++){
            for (int j=0;j<rowcol;j++){
                System.out.println("Mời nhập giá trị ở hàng "+(i+1)+" cột "+(j+1));
                arr[i][j]=scanner.nextInt();
            }
        }
        return arr;
    }
    public static void displayArr(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
