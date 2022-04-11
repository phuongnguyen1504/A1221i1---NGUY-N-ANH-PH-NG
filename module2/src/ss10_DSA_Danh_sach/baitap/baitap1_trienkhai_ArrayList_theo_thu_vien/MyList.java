package ss10_DSA_Danh_sach.baitap.baitap1_trienkhai_ArrayList_theo_thu_vien;

import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyList() {
        elements=new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements=new Object[capacity];
    }
    private void ensureCapacity(int minCapacity){
        int newSize=elements.length+minCapacity;
        elements= Arrays.copyOf(elements,newSize);
    }
    public boolean add(E element){
        if (size== elements.length){
            ensureCapacity(2);
        }
        elements[size++]=element;
        return true;
    }
    public void add(int index,E element){
        if (index>=0&&index<size){
            for(int i=elements.length-2;i>=index;i--){
                elements[i+1]=elements[i];
            }
            elements[index]=element;
            size++;
        }
        else {
            System.out.println("Out of index");
        }
    }
    public E remove(int index){
        Object value;
        if (index>=0&&index<size){
            value=elements[index];
            for (int i=index;i<size;i++){
                elements[i]=elements[i+1];
            }
            size--;
            return (E)value;
        }
        else {
            System.out.println("Out of index");
            return null;
        }

    }
    public int size(){
        return size;
    }
    public Object clone(){
        int newSize=elements.length+2;
        return elements= Arrays.copyOf(elements,newSize);
    }
    public boolean contains(E o){
        for (int i=0;i<size;i++){
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(Object o){
        int index=-1;
        for (int i=0;i<size;i++){
            if(elements[i].equals(o)){
                index=i;
                return index;
            }
        }
        return index;
    }
    public E get(int i){
        return (E) elements[i];
    }
    public void clear(){
        size=0;
        elements=new Object[DEFAULT_CAPACITY];
    }
}