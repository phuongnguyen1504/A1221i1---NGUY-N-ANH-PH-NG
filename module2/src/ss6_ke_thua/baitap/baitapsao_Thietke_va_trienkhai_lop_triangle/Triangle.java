package ss6_ke_thua.baitap.baitapsao_Thietke_va_trienkhai_lop_triangle;

import ss6_ke_thua.thuchanh.thuchanh1_he_cac_doi_tuong_hinh_hoc.Shape;

public class Triangle extends Shape {
    private double side1=1.0;
    private double side2=1.0;
    private double side3=1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        if (side1>=side2+side3||side2>=side1+side3||side3>=side1+side2){
            System.out.println("Ba canh khong phai la canh cua tam giac");
            return 0;
        }
        else {
            double p=getPerimeter();
            return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        }
    }
    public double getPerimeter(){
        return side1+side2+side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}'+"dien tich="+getArea()+", chu vi tam giac="+getPerimeter()+"; "+super.toString();
    }
}
