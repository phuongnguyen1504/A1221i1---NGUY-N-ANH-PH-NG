package ss19_String_regex.baitap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    private static final String REGEX="^[CAP]\\d{4}[GHIKLM]$";


    public ValidateClass() {
    }
    public boolean isValid(String regex){
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ten lop:");
        String input=scanner.nextLine();
        ValidateClass validateClass=new ValidateClass();
        System.out.println(input+" is valid:"+validateClass.isValid(input));
    }
}
