import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args){
        String dateString = "30/2/2022";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
        try {
            df.parse(dateString); // parse dateString thành kiểu Date
            System.out.println("Ngay sinh hop le");
        }
        catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
            System.out.println("Invalid date");
        }
    }
}
