package ss14_Sort_algorithm.baitap.baitap1_minhhoa_InsertSort;

import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] list){
        for (int i=1;i<list.length-1;i++){
            int key=list[i];
            int j=i-1;
            while (j>=0&&list[j]>key){
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list:\n");
        for (int li : list) {
            System.out.println(li + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
        for (int li:list){
            System.out.print(li+" ");
        }
    }
}
