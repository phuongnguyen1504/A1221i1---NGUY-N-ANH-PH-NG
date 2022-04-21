package ss14_sort.view;

import java.util.Arrays;

public class DemoSort {
    public static void main(String[] args) {
        int[] arr = {3, 44, 38, 5, 47, 15, 36};
        //bubbleSort
//        boolean isSwap = true;
//        for (int i = 0; i < arr.length - 1 && isSwap; i++) {
//            isSwap = false;
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    isSwap = true;
//                }
//            }
//        }

        //Selection sort
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min_index = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min_index]) {
//                    min_index = j;
//                }
//            }
//            if (min_index != i) {
//                int temp= arr[min_index];
//                arr[min_index] = arr[i];
//                arr[i] = temp;
//            }
//        }

        //insertion sort
//        for (int i = 1; i < arr.length; i++) {
//            int key = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = key;
//        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
