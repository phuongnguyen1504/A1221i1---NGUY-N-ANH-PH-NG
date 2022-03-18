package ss2_vonglap_java.thuchanh;

import java.util.Scanner;

public class thuchanh2_tinhtienlaivay {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập số tiền cho vay:");
        int amount=sc.nextInt();
        System.out.println("Nhập lãi suất % theo năm");
        float rate=sc.nextFloat();
        System.out.println("Nhập số tháng cho vay:");
        int month=sc.nextInt();
        //số tiền lãi=số tiền gửi*tỉ lệ vay theo năm(%)/12*số tháng vay;
        double totalInterest=0;
        for (int i=0;i<month;i++){
            totalInterest+=amount*((rate/100)/12)*month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
