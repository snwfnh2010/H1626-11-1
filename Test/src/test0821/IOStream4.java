package test0821;

import java.io.*;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream4 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream("F:\\Avicii-Levels.mp3"));
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("F:\\test01\\Avicii-Levels.mp3"));
            int length=0;
            while (-1!=(length=bis.read())){
                bos.write(length);
            }
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
