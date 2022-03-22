package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap4_tim_phan_tu_lon_nhat_trong_mang_2_chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời nhập số hàng:");
        int row = scanner.nextInt();
        System.out.println("Mời nhập số cột:");
        int column = scanner.nextInt();
        int arr[][] = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("Mời nhập phần tử ở hàng thứ " + (i + 1) + " cột " + (j + 1) + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Ma trận sau khi khởi tạo:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int max = arr[0][0];
        int x = 1;
        int y = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] > max) {
                    x = i+1;
                    y = j+1;
                    max = arr[i][j];
                }
            }
        }
        System.out.println("Giá trị lớn nhất của ma trận là: "+max+" ở hàng thứ "+x+" cột thứ "+y);
    }
}
