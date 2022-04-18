package ss13_Searching_algorithms.baitap.baitap1_tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindStringLength {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a string:");
        String string=scanner.nextLine();

        LinkedList<Character>max=new LinkedList<>();
        for (int i=0;i<string.length();i++){
            LinkedList<Character> list=new LinkedList<>();
            list.add(string.charAt(i));
            for (int j=i+1;j<string.length();j++){
                if (string.charAt(j)>list.getLast()){
                    list.add(string.charAt(j));
                }
            }
            if(list.size()>max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character ch:max){
            System.out.print(ch);
        }
        System.out.println();
    }
}
/******************************************************
Tính độ phức tạp thuật toán:
 T(n)=O(n)*O(n)+O(n)=O(n^2)+O(n)=O(n^2)
 =>Độ phúc tạp thuật toán là O(n^2)
******************************************************/
