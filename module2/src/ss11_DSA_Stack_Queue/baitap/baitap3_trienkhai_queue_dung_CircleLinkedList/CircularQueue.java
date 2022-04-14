package ss11_DSA_Stack_Queue.baitap.baitap3_trienkhai_queue_dung_CircleLinkedList;

public class CircularQueue {
    static class Node{
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }
    }
    static class Queue{
        private Node front;
        private Node rear;

        public Queue() {
        }
    }
    public static void enQueue(Queue q, int value){
        Node temp=new Node(value);
        if (q.front==null){
            q.front=temp;
        }
        else{
            q.rear.link=temp;
        }
        q.rear=temp;
        q.rear.link=q.front;
    }
    public static int deQueue(Queue q){
        if (q.front==null){
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (q.front==q.rear){
            value=q.front.data;
            q.front=null;
            q.rear=null;
        }
        else{
            Node temp=q.front;
            value=temp.data;
            q.front=q.front.link;
            q.rear.link=q.front;
        }
        return value;
    }
    public static void displayQueue(Queue q){
        Node temp=q.front;
        System.out.printf(" Elements in Circular Queue are: ");
        while (temp.link!=q.front){
            System.out.printf("%d ", temp .data);
            temp=temp.link;
        }
        System.out.printf("%d", temp .data);
        System.out.println();

    }

    public static void main(String[] args) {
        Queue q=new Queue();
        q.front= q.rear=null;
        enQueue(q,14);
        enQueue(q, 15);
        enQueue(q, 16);
        enQueue(q, 22);
        enQueue(q, 33);
        displayQueue(q);
        System.out.printf(" Deleted value = %d", deQueue(q));
        System.out.println();
        System.out.printf(" Deleted value = %d", deQueue(q));
        System.out.println();
        displayQueue(q);
        enQueue(q, 44);
        enQueue(q, 55);
        displayQueue(q);
    }
}
