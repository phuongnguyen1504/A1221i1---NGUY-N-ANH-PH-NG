package ss12_DSA_Java_Collection_Framework.thuchanh.thuchanh3_sap_xep_voi_comparable_va_conparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge()>o2.getAge()){
            return 1;
        }
        else if (o1.getAge()==o2.getAge()){
            return 0;
        }
        else {
            return -1;
        }
    }
}
