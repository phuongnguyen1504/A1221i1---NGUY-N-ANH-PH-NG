package ss14_Sort_algorithm.baitap.baitap2_caidat_insertionSort;

public class InsertionSort {
    static int[] list={2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void insertionSort(int[] list){
        for (int i=1;i< list.length;i++){
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
        insertionSort(list);
        for (int li: list){
            System.out.print(li+" ");
        }
    }
}
