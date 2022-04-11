package ss10_DSA_Danh_sach.baitap.baitap2_trienkhai_LinkedList_theo_thu_vien;

public class MyLinkedList {
    private Node head;
    private int numNode;
    class Node{
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
    public MyLinkedList() {
    }
    public MyLinkedList(Object data){
        head=new Node(data);
    }
    public void add(int index,Object data){
        Node temp=head;
        Node holder;
        for (int i=0;i<index-1&&temp.next!=null;i++){
            temp=temp.next;
        }
        holder=temp.next;
        temp.next=new Node(data);
        temp.next.next=holder;
        numNode++;
    }
    public void addFirst(Object data){
        Node temp=head;
        head=new Node(data);
        head.next=temp;
        numNode++;
    }
    public void addLast(Object data){
        if (head==null){
            addFirst(data);
        }
        else {
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(data);
            numNode++;
        }
    }
    public void remove(int index){
        Node temp = head;
        Node holder;
        if (index==0){
            head=temp.next;
            numNode--;
        }
        else if (index>0&&index<size()){
            for (int i=0;i<index-1&&temp.next!=null;i++){
                temp=temp.next;
            }
            holder=temp.next.next;
            temp.next=holder;
            numNode--;
        }
        else {
            System.out.println("Index: "+index+" Size "+(size()-1));;
        }
    }
    public void remove(Object o){
        remove(indexOf(o));
    }

    public void get(int index){
        Node temp=head;
        for (int i=0;i<index;i++){
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public int size(){
        Node temp=head;
        int i=0;
        while (temp!=null){
            temp=temp.next;
            i++;
        }
        return i;
    }
    public boolean contains(Object data){
        Node temp=head;
        for (int i=0;i<=numNode;i++){
            if ((temp.data).equals(data)){
                return true;
            }
            else{
                temp=temp.next;
            }
        }
        return false;
    }
    public int indexOf(Object data){
        Node temp=head;
        int index=-1;
        for (int i=0;i<=numNode;i++){
            if ((temp.data).equals(data)){
                return i;
            }
            else {
                temp=temp.next;
            }
        }
        return index;
    }
    public void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

}
