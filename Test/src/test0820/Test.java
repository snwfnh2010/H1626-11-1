package test0820;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class Test {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://www.baidu.com/img/bd_logo1.png");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);


            InputStream inputStream = url.openStream();
            File file=new File("F:"+File.separator+"baidu.png");
            file.createNewFile();
            OutputStream os=new FileOutputStream(file);
            byte[] bytes=new byte[1024];
            StringBuilder sb=new StringBuilder();
            int length=0;
            while (-1!=(length=inputStream.read(bytes))){
                os.write(bytes,0,length);
                os.flush();
            }
            os.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
