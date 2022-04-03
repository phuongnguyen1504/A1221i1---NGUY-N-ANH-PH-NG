package ss7_AbstractClass_va_Interface.baitap.baitap1_trienkhai_interface_Resizeable_cho_lop_hinh_hoc;

public class CircleTest {
    public static void main(String[] args) {;
        Circle circle=new Circle();
        System.out.println("Truoc khi resize dien tich="+circle.getArea());
        int rand=(int)(Math.random()*100);
        System.out.println("Sau khi resize tang them: "+ rand+" % dien tich="+circle.resize(rand));
    }
}
