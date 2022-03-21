package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

import java.util.Scanner;

public class thuchanh2_tim_gia_tri_trong_mang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập tên cần tìm:");
        String input_name=scanner.nextLine();
        boolean isExit=false;
        for (int i=0;i<students.length;i++){
            if (students[i].equals(input_name)){
                System.out.println("Số thứ tự tương ứng với sinh viên: "+input_name+" là: "+(i+1));
                isExit=true;
                break;
            }
        }
        if (!isExit){
            System.out.println("Không tìm thấy sinh viên "+input_name+" trong list!");
        }
    }
}
