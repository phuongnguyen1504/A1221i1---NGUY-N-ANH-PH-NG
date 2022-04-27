package ss16_io_text.baitap.copy_file_text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class CopyFileText {
    private static final String path="src/ss16_io_text/baitap/";
    public static void copyFile(String source,String filePath) throws IOException{
        Path origin= Paths.get(path+source);
        Path copy=Paths.get(path+filePath);
        //toAbsolutePath: lấy đường dẫn tuyệt đối của nó vd:D://src//ss16....../source
        //StandardCopyOption.REPLACE_EXISTING : thay thế nếu nó tồn tại tức là ghi đè vào nếu có file đó tại đường dẫn
        Files.copy(origin.toAbsolutePath(),copy.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
    }
    public static void copyObsolete(String source,String desPath) throws IOException{
        FileInputStream sourceFile=new FileInputStream(path+source);
        FileOutputStream destFile=new FileOutputStream(path+desPath);
        byte[] list=new byte[10];
        sourceFile.read(list);
        destFile.write(list);
        sourceFile.close();
        destFile.close();
    }
    public static void readFile(String source) throws IOException{
        List<String> lst=Files.readAllLines(Paths.get(path+source));
        lst.stream().forEach(s -> {
            System.out.println(s);
        });
    }
    public static void main(String[] args) {
        try{
            copyFile("1.txt","2.txt");
            readFile("1.txt");
            copyObsolete("1.txt","3.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
