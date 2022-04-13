package ss11_DSA_Stack_Queue.baitap.baitap1_dao_nguoc_phan_tu_su_dung_stack;

import java.util.Stack;

public class ReserveUsingStack {
    public static void main(String[] args) {
        int[] number=new int[3];
        number[0]=1;
        number[1]=2;
        number[2]=3;
        ReversedIntList(number);
        ReversedString();

    }

    private static void ReversedString() {
        Stack<String> stack=new Stack<>();
        String hello="Hello World";
        System.out.println("Chuỗi trước đảo ngược là:");
        System.out.println(hello);
        String[] helloItem=hello.split("");
        for (String item:helloItem){
            stack.push(item);
        }
        System.out.println("Chuỗi sau khi đảo ngược:");
        for (String item:helloItem){
            System.out.printf("%s",stack.pop());
        }
        System.out.println();
    }

    private static void ReversedIntList(int[] number) {
        System.out.println("Mảng số nguyên trước khi đảo ngược");
        for (int num: number){
            System.out.printf(" %d",num);
        }
        System.out.println();
        Stack<Integer> stack=new Stack<Integer>();
        for (int num: number){
            stack.push(num);
        }
        System.out.println("Mảng số nguyên sau khi đảo ngược:");
        for (int num: number){
            System.out.printf(" %d",stack.pop());
        }
        System.out.println();
    }
}
