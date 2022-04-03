package ss7_AbstractClass_va_Interface.thuchanh.thuchanh2_trienkhai_interface_Comparable_cho_cac_lop_hinh_hoc;

import ss6_ke_thua.thuchanh.thuchanh1_he_cac_doi_tuong_hinh_hoc.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius())
            return 1;
        else if (getRadius() < o.getRadius())
            return -1;
        else
            return 1;
    }
    // a vs b
    // a.compareTo(b)

}
