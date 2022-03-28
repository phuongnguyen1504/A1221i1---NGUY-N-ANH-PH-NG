package ss5_Accessmodifier_static_method_staticproperty.baitap.baitap1_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle(2);
        System.out.println("Ban kinh hinh tron la: "+circle.getRadius());
        System.out.println("Dien tich hinh tron la: "+circle.getArea());
    }
}
