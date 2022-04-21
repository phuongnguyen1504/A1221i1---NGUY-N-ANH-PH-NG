package ss14_Sort_algorithm.thuchanh.thuchanh2_minh_hoa_bubblesort_algorithm;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list:");
        for (int li : list) {
            System.out.println(li + "\t");
        }
        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        boolean isSwap = true;
        for (int i = 0; i < list.length - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int tmp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if (isSwap == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.println("List after the " + i + " sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
