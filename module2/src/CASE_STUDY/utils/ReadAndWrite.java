package CASE_STUDY.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadAndWrite<T> {
    public static void readFile(String path){

    }
    public void writeFile(List<T> tList,String path, boolean isAppend){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend));
            for (T t: tList){
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
