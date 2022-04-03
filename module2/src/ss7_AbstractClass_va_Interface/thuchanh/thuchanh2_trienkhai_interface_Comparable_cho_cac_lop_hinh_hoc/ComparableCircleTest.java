package ss7_AbstractClass_va_Interface.thuchanh.thuchanh2_trienkhai_interface_Comparable_cho_cac_lop_hinh_hoc;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles=new ComparableCircle[3];
        circles[0]=new ComparableCircle(3.6); // 3.6
        circles[1]=new ComparableCircle(); // 1
        circles[2]=new ComparableCircle("indigo",false,3.5); // 3.5
        System.out.println("Pre-sorted:");
        for(ComparableCircle circle:circles){
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("After sorted:");
        for(ComparableCircle circle:circles){
            System.out.println(circle);
        }
    }
}
