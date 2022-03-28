package ss5_Accessmodifier_static_method_staticproperty.thuchanh.thuchanh2_Static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1=new Car("Mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCars);
        Car car2=new Car("Mazda 6","Skyactiv 6");
        System.out.print(Car.numberOfCars);
    }
}
