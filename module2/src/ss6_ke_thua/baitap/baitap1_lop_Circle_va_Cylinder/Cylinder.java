package ss6_ke_thua.baitap.baitap1_lop_Circle_va_Cylinder;

public class Cylinder extends Circle{
    private double height=1.0;
    public Cylinder() {
    }

    public Cylinder(double height,double radius, String color) {
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getArea()*getHeight();
    }
    @Override
    public String toString(){
        return "A cylinder has height="+getHeight()+" and volume of cylinder ="+getVolume()+super.toString();
    }
}
