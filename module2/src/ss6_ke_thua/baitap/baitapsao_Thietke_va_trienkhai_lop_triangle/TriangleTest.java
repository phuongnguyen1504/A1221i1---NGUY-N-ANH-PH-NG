package ss6_ke_thua.baitap.baitapsao_Thietke_va_trienkhai_lop_triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        System.out.println(triangle);
        triangle=new Triangle(2,3,4);
        System.out.println(triangle);
        triangle=new Triangle("red",true,4,5,6);
        System.out.println(triangle);
    }
}
