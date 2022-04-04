package ss8_clean_code_va_refactoring.thuchanh.thuchanh1_refactoring_doi_ten_bien_va_tach_hang;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        double value=calculator.calculate(2,3,Calculator.ADDITION);
        System.out.println(value);
        value=calculator.calculate(2,2,calculator.DIVISION);
        System.out.println(value);
    }
}
