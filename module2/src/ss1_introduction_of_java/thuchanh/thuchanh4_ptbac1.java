package ss1_introduction_of_java.thuchanh;

import java.util.Scanner;
public class thuchanh4_ptbac1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a: ");
        double a=scanner.nextDouble();
        System.out.print("Enter b: ");
        double b=scanner.nextDouble();
        System.out.print("Enter c: ");
        double c=scanner.nextDouble();
        if (a!=0){
            double answer=(c-b)/a;
            System.out.printf("Phương trình có nghiệm là x = %f!\n", answer);
        }
        else {
            if (b==c){
                System.out.print("Phương trình có vô số nghiệm");
            }
            else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}
