import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class test {
    public static void main(String[] args){
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
