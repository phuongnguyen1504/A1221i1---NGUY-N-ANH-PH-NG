package ss10_DSA_Danh_sach.baitap.baitap1_trienkhai_ArrayList_theo_thu_vien;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> elements = new MyList<String>();
        elements.add("B");
        elements.add(0, "A");
        elements.add("C");
        elements.add(0,"1");
        //elements.remove(1);
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
        System.out.println("Kiểm tra chứa phần tử");
        System.out.println(elements.contains("D"));
        System.out.println(elements.indexOf("1"));
        System.out.println("Sau khi clear");
        elements.clear();
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
        System.out.println("Tạo lại đói tượng");
        elements = new MyList<String>();
        elements.add("B");
        elements.add(0, "A");
        elements.add("C");
        elements.add(0,"1");
        //elements.remove(1);
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
    }
}
