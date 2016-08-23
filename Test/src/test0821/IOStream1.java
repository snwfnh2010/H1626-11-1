package test0821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream1 {
    public static void main(String[] args) {
        try {
            FileReader fr=new FileReader("Test\\src\\test0821\\a.txt");
            int length=0;
            while (-1!=(length=fr.read())){
                System.out.println((char)length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
