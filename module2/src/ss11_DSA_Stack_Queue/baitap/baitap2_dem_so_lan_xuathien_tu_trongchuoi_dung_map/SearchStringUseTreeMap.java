package ss11_DSA_Stack_Queue.baitap.baitap2_dem_so_lan_xuathien_tu_trongchuoi_dung_map;

import java.util.Scanner;
import java.util.TreeMap;

public class SearchStringUseTreeMap {
    public static void main(String[] args) {
        System.out.println("Mời nhập chuỗi:");
        String words=new Scanner(System.in).nextLine();
        String[] word= words.toLowerCase().split(" ");
        TreeMap<String, Integer> text=new TreeMap<>();
        int temp=1;
        //Nếu không tìm thấy từ khóa trong mảng word nằm trong text thì sẽ put để thêm vào trong treeMap; còn có thì
        //dùng replace để thêm value ++ lên
        for (int i=0;i< word.length;i++){
            String c=word[i];
            if (!text.containsKey(c)){
                text.put(c,temp);
            }
            else {
                text.replace(c,temp+1);
            }
        }
        System.out.println(text);
    }
}
