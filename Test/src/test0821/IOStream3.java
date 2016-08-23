package test0821;

import java.io.*;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream3 {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new FileReader("Test\\src\\test0821\\b.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("Test\\src\\test0821\\c.txt"));
            String line=null;
            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
