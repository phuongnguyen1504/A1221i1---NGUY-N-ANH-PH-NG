package CASE_STUDY.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite<T> {
    public void writeFile(List<T> input,String path, boolean isAppend){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend));
            for(T t:input) {
                bufferedWriter.write((String) t);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(List<T> input,String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for(T t:input) {
                bufferedWriter.write((String) t);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
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
