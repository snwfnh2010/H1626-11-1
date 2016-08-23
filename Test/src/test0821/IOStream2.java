package test0821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream2 {
    public static void main(String[] args) {
        FileReader fr=null;
        try {
            fr=new FileReader("Test\\src\\test0821\\b.txt");
            char[] chars=new char[1024];
            int length=0;
            while (-1!=(length=fr.read(chars))){
                System.out.println(new String(chars,0,length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
