package ss7_AbstractClass_va_Interface.baitap.baitap1_trienkhai_interface_Resizeable_cho_lop_hinh_hoc;

public class Rectangle extends Shape implements Resizeable{
    private double width=1.0;
    private double height=1.0;
    public Rectangle(){
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return (width+height)*2;
    }
    @Override
    public String toString(){
        return "A Rectangle with width="+width+" and length="+height+", which is a subclass of "+super.toString();
    }

    @Override
    public double resize(double percent) {
        return getArea()*(1+(percent/100));
    }
}
