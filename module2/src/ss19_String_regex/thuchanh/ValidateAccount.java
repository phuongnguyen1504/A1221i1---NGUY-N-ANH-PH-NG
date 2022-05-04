package ss19_String_regex.thuchanh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String ACCOUNT_REGEX="^[a-z0-9_]{6,}$";

    public ValidateAccount() {
    }
    public boolean validate(String regex){
        Pattern pattern=Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
