package ss10_DSA_Danh_sach.baitap.baitap2_trienkhai_LinkedList_theo_thu_vien;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList(1);
        list.add(1, 2);
        list.add(2,"Melinda");
        list.add(3,4);
        list.add(4,5);
        list.addFirst(0);
        list.addLast(6);
        System.out.println("Danh sách các phần tử:");
        list.printList();
        list.remove("Melinda");
        System.out.println("Danh sách các phần tử sau khi xóa:");
        list.printList();
        System.out.println("Danh sách các phần tử sau khi chèn vào index 3:");
        list.add(3,3);
        list.printList();
        System.out.println("Tìm phần từ vị trí 2");
        list.get(2);
        System.out.println("Tìm kiếm phần tử:");
        System.out.println(list.contains(0));
        System.out.println(list.contains(6));
    }
}
