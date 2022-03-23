package ss3_Mang_va_phuong_thuc_trong_java.thuchanh;

public class thuchanh5_tim_gia_tri_nho_nhat_trong_mang {
    public static int minValue(int[] array){
        int min=array[0];
        int index=0;
        for (int i=1;i<array.length;i++){
            if (array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] array={4, 12, 7, 8, 1, 6, 9};
        int index=minValue(array);
        System.out.println("Giá trị nhỏ nhất trong mảng là: "+array[index]);
    }
}
