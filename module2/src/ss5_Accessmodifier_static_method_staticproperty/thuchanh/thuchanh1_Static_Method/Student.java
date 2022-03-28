package ss5_Accessmodifier_static_method_staticproperty.thuchanh.thuchanh1_Static_Method;

public class Student {
    private int rollno;
    private String name;
    private static String college="BBDIT";
    Student(int r,String n){
        rollno=r;
        name=n;
    }
    static void change(){
        college="CODEGYM";
    }
    void display(){
        System.out.println(rollno+" "+name+" "+college);
    }
}

