package CASE_STUDY.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite<T> {
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
    public List<String> readFile(String path){
        List<String> res = new ArrayList<>();
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                res.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
