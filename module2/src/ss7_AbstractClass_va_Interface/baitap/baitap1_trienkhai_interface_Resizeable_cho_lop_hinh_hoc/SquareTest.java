package ss7_AbstractClass_va_Interface.baitap.baitap1_trienkhai_interface_Resizeable_cho_lop_hinh_hoc;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println("Truoc khi resize dien tich="+square.getArea());
        int rand=(int)(Math.random()*100);
        System.out.println("Sau khi resize tang them: "+ rand+" % dien tich="+square.resize(rand));
    }
}