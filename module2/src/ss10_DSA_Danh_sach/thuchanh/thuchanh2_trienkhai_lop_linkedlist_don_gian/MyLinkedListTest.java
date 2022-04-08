package ss10_DSA_Danh_sach.thuchanh.thuchanh2_trienkhai_lop_linkedlist_don_gian;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList(10);
        myLinkedList.addFirst(9);
        myLinkedList.add(1,9.5);
        myLinkedList.printList();
    }
}
