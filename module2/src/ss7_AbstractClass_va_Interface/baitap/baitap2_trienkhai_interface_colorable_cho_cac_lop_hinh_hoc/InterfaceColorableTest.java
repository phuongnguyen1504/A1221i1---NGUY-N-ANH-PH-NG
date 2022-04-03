package ss7_AbstractClass_va_Interface.baitap.baitap2_trienkhai_interface_colorable_cho_cac_lop_hinh_hoc;

public class InterfaceColorableTest {
    public static void main(String[] args) {
        Shape[] shape=new Shape[3];
        shape[0]=new Circle();
        shape[1]=new Rectangle();
        shape[2]=new Square();
        for (Shape shapes:shape){
            if (shapes instanceof Square){
                ((Square) shapes).howToColor();
            }
            else {
                System.out.println(shapes.getArea());
            }
        }
    }
}
