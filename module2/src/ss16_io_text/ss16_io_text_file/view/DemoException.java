package ss16_io_text_file.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DemoException {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
////        try {
////            int i = Integer.parseInt(scanner.nextLine());
////        } catch (NumberFormatException e) {
////            System.out.println("Giá trị phải là số.");
////        } catch (Exception e) {
////            System.out.println(e.getMessage());
////        } finally {
////            System.out.println("Khối finally");
////        }
        try {
            new DemoException().check();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }


        File file = new File("C://index.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("123");
    }

    public void check() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
    }

    public void check2() {
        this.check();
    }
}
