package test0821;

import java.io.File;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream5 {
    public static void main(String[] args) {
        File f1=new File("F:/test01/Avicii-Levels.mp3");
        File f2=new File("F:/test01/s.wmv");
        f1.renameTo(f2);
    }
}
