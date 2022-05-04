package ss19_String_regex.thuchanh;

public class TestEmail {
    private static ValidateMail validateMail;
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        validateMail=new ValidateMail();
        for(String mail:validEmail){
            boolean isValid= validateMail.isValidate(mail);
            System.out.println("Email is: "+mail+" is valid: "+isValid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validateMail.isValidate(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}
