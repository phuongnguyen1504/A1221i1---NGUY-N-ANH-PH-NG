package bai_tap_lam_them.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite <T>  {
    public void WriteFile(String line, String path, boolean isAppend) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, isAppend));
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<T> ReadFile(String path) {
        List<T> res = new ArrayList<>();
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                res.add((T) line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
