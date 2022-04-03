package ss7_AbstractClass_va_Interface.baitap.baitap2_trienkhai_interface_colorable_cho_cac_lop_hinh_hoc;

public class Square extends Rectangle {

    public Square() {
    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side,String color,boolean filled){
        super(color,filled,side,side);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setHeight(side);
    }
    @Override
    public void setWidth(double width) {
        setSide(width);
    }
    @Override
    public void setHeight(double height){
        setSide(height);
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
