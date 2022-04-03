package ss7_AbstractClass_va_Interface.thuchanh.thuchanh3_trienkhai_interface_Comparator_de_so_sanh_lop_hinhhoc;

import ss6_ke_thua.thuchanh.thuchanh1_he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles=new Circle[3];
        circles[0]=new Circle(3.6);
        circles[1]=new Circle();
        circles[2]=new Circle("Indigo",false,3.5);
        System.out.println("Pre-sorted:");
        for(Circle circle:circles){
            System.out.println(circle);
        }
        Comparator circleComparator=new CircleComparator();
        Arrays.sort(circles,circleComparator);
        System.out.println("After-sorted:");
        for(Circle circle:circles){
            System.out.println(circle);
        }
    }
}
