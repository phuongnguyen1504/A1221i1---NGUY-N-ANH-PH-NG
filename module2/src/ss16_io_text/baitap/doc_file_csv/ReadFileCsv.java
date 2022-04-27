package ss16_io_text.baitap.doc_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileCsv {
    private static final String path="D:\\Codegym\\module2\\src\\ss16_io_text\\baitap\\doc_file_csv\\countries.csv";

    public static void main(String[] args) {
        try{
            readCsv(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readCsv(String source) throws IOException{
        BufferedReader bufferedReader=new BufferedReader((new FileReader(path)));
        String line="";
        while((line=bufferedReader.readLine())!=null){
            String[]country=line.split(",");
            System.out.println("Country[code= " + country[1] + " , name=" + country[2] + "]");
        }

    }
}
