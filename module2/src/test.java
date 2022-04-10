import java.util.ArrayList;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<String> phantu=new LinkedList<String>();
        phantu.add("aBC");
        phantu.add(0,"ABD");
        phantu.clone();
        phantu.remove("ABD");
        System.out.println(phantu);
    }
}
