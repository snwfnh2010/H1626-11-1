package test0821;

import java.io.File;
import java.io.IOException;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream7 {
    public static void main(String[] args) {


            try {
                File file=new File("F:/test/a/a.txt");
                if(!file.exists()){

                    String path=file.getAbsolutePath();
                    String parapath=path.substring(0,path.lastIndexOf(File.separator));
                    File paraPath=new File(parapath);
                    paraPath.mkdirs();
                    file.createNewFile();

                }else
                    System.out.println(file.getParentFile());


            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
