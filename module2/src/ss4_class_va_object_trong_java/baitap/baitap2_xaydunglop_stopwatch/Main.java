package ss4_class_va_object_trong_java.baitap.baitap2_xaydunglop_stopwatch;

import java.time.LocalTime;

public class Main {
    public static int[] selectionSort(int ...a){
        for (int i=0;i<a.length-1;i++){
            for (int j=i+1;j<a.length;j++){
                if (a[j]<a[i]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a=new int[100000];
        for (int i=0;i<100000;i++){
            a[i]=(int)(Math.random()*1000);
        }
        LocalTime start=LocalTime.now();
        selectionSort(a);
        LocalTime end=LocalTime.now();
        StopWatch sw=new StopWatch(start,end);
        System.out.println("Time: "+sw.getElapsedTime()+" miliseconds");
    }
}
