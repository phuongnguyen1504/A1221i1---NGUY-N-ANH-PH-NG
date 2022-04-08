package ss10_DSA_Danh_sach.baitap.baitap1_trienkhai_ArrayList_theo_thu_vien;

import java.util.Arrays;

public class MyList<E>{
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];
    public MyList() {
        elements=new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements=new Object[capacity];
    }
    private void ensureCap(){
        int newSize=elements.length*2;
        elements= Arrays.copyOf(elements,newSize);
    }
    public void add(int index,E element){
        if (size==elements.length){
            ensureCap();
        }
        Object temp= elements[index];
        for(int i=index;i<size;i++){
            elements[i]=element;
            elements[i+1]=element[i];
    }
    }
}
