import java.util.Scanner;
public class thuchanh3_toantu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner=new Scanner(System.in);//Khai báo đối tượng scanner
        System.out.println("Enter width: ");
        width=scanner.nextFloat();//Nhập chiều rộng
        System.out.println("Enter height: ");
        height=scanner.nextFloat();
        float area=width*height;
        System.out.println("Area is: "+area);
    }
}
