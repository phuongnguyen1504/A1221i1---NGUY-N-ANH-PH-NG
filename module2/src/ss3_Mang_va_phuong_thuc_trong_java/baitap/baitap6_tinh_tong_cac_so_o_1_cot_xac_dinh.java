package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap6_tinh_tong_cac_so_o_1_cot_xac_dinh {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int arr[][]=createArray();
        displayArr(arr);
        int column;
        do {
            System.out.println("Mời bạn nhập cột cần tính tổng số:");
            column = scanner.nextInt();
            if (column> arr.length){
                System.out.println("Cột không được vượt quá "+arr.length);
            }
        }while (column<1||column> arr.length);
        int sum=0;
        for (int i=0;i< arr.length;i++){
            sum+=arr[i][column-1];
        }
        System.out.println("Tổng các số ở cột thứ "+column+" là: "+sum);

    }
    public static int[][] createArray(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mời nhập số hàng:");
        int row=scanner.nextInt();
        System.out.println("Mời nhập số cột:");
        int col=scanner.nextInt();
        int arr[][]=new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
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
