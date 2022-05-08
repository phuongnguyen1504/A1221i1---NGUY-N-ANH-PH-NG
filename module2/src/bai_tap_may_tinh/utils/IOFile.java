package bai_tap_may_tinh.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class IOFile<T> {
    public void write(String input,String PATH,boolean isAppend){
        String line="";
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(PATH,true));
            bufferedWriter.write(input);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(List<String> input, String PATH){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(PATH));
            for (String set:input){
                bufferedWriter.write(set);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<T> read(String Path){
        String line="";
        List<T> res=new ArrayList<>();
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(Path));
            while((line=bufferedReader.readLine())!=null){
                res.add((T) line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
