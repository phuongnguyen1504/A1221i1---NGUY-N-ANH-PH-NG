package ss7_AbstractClass_va_Interface.thuchanh.thuchanh3_trienkhai_interface_Comparator_de_so_sanh_lop_hinhhoc;

import ss6_ke_thua.thuchanh.thuchanh1_he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius()> o2.getRadius())
            return  1;
        else if(o1.getRadius()<o2.getRadius())
            return -1;
        else
        return 0;
    }
}
