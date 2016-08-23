package test0821;

import java.io.File;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class FileTest {
    public static void main(String[] args) {
        File file=new File("F:/test01");
        FileDelete.deleteALL(file);
    }
}
