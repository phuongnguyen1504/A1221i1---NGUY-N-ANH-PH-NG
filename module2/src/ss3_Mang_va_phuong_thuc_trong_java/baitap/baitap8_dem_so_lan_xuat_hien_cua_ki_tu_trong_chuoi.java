package ss3_Mang_va_phuong_thuc_trong_java.baitap;

import java.util.Scanner;

public class baitap8_dem_so_lan_xuat_hien_cua_ki_tu_trong_chuoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Mời nhập chuỗi:");
        String str=scanner.nextLine();
        System.out.println("chuỗi nhập vào là: "+str);
        System.out.println("Mời nhập kí tự cần tìm:");
        String key=scanner.nextLine();

        int dem=0;
        for (int i=0;i<str.length();i++){
            System.out.println(String.valueOf(str.charAt(i)));
            if (String.valueOf(str.charAt(i)).equals(key)){
                dem++;
            }
        }
        System.out.println("Kí tự "+key+" xuất hiện: "+dem+" lần");
    }
}
