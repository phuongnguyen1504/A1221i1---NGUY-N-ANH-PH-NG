package ss14_Sort_algorithm.thuchanh.thuchanh3_cai_dat_SelectionSort;

public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                double temp = list[min_index];
                list[min_index] = list[i];
                list[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (double li : list) {
            System.out.print(li + " ");
        }
    }
}
