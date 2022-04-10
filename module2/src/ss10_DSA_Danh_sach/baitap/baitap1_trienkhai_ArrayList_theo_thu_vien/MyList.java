package ss10_DSA_Danh_sach.baitap.baitap1_trienkhai_ArrayList_theo_thu_vien;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        elements = new Object[size];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public void add(int index, E element) {
        if (index >= 0 && index <= size) {
            size++;
            ensureCapa();
        }
        for (int i = elements.length - 2; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
    }

    public E remove(int índex) {
        E temp = null;
        if (índex >= 0 && índex <= size) {
            temp = (E) elements[índex];
            for (int i = índex; i < elements.length - 2; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
        return temp;
    }
    public int size() {
        return size;
    }
    @Override
    public E clone(){
        MyList<E> clone=new MyList<>(elements.length);
        for (Object x:elements){
            clone.add((E) x);
        }
        return (E) clone;
    }
    public boolean contains(E o){
        for (Object x:elements){
            if (o.equals(x)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E o){
        int index=-1;
        for (int i=0;i<elements.length;i++){
            if (elements[i].equals(o)){
                return i;
            }
        }
        return index;
    }
    public E get(int index){
        if (index>=0&&index<size){
            return (E) elements[index];
        }
        return null;
    }
    public void clear(){
        elements=new Object[DEFAULT_CAPACITY];
        size=0;

    }
}
