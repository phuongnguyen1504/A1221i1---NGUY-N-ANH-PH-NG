package ss8_clean_code_va_refactoring.thuchanh.thuchanh2_tach_bien;

import javafx.scene.transform.Scale;

import java.util.Scanner;

import static ss8_clean_code_va_refactoring.thuchanh.thuchanh2_tach_bien.FizzBuzz.fizzBuzz;

public class FizzBuzzTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("Mời nhập giá trị vào:");
            int number= Integer.parseInt(scanner.nextLine());
            System.out.println(fizzBuzz(number));
        }

    }
}
