package ss4_class_va_object_trong_java.baitap.baitap1_xaydung_lop_QuadraticEquation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    double delta;
    public QuadraticEquation(){
    }
    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public double getDiscriminant(){
        double delta=b*b-4*a*c;
        return this.delta=delta;
    }
    public double getRoot1(){
        return (-this.b+Math.sqrt(this.delta))/(2*this.a);
    }
    public double getRoot2(){
        return (-this.b-Math.sqrt(this.delta))/(2*this.a);
    }
    public double getsquareRoot(){
        return -this.b/2*a;
    }

}
