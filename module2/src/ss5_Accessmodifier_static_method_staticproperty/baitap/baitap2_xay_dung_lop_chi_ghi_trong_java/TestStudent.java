package ss5_Accessmodifier_static_method_staticproperty.baitap.baitap2_xay_dung_lop_chi_ghi_trong_java;

public class TestStudent {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Chris");
        student.setClasses("A1221I1");
        System.out.println("Ten: "+student.getName());
        System.out.println("Lop: "+student.getClasses());
    }
}
