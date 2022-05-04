package ss19_String_regex.baitap;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTelephone {
    private static final String REGEX="^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public boolean isValid(String regex){
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap so dien thoai:");
        String tel=scanner.nextLine();
        ValidateTelephone validTel=new ValidateTelephone();
        System.out.println(tel+" is valid: "+validTel.isValid(tel));
    }
}
