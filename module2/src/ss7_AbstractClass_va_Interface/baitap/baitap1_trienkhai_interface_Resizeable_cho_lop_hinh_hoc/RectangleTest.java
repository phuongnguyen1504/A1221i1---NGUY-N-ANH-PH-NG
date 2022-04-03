package ss7_AbstractClass_va_Interface.baitap.baitap1_trienkhai_interface_Resizeable_cho_lop_hinh_hoc;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle();
        System.out.println("Truoc khi resize dien tich="+rectangle.getArea());
        int rand=(int)(Math.random()*100);
        System.out.println("Sau khi resize tang them: "+ rand+" % dien tich="+rectangle.resize(rand));

    }
}
