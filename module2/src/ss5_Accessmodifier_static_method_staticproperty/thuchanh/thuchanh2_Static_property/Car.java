package ss5_Accessmodifier_static_method_staticproperty.thuchanh.thuchanh2_Static_property;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    public Car(String name,String engine){
        this.name=name;
        this.engine=engine;
        numberOfCars++;
    }
}
