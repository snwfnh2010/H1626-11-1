package test0821;

import java.io.*;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream6 {
    public static final int INT = 1024*1024*10;

    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("F:/test/12_End.mp4");
            FileOutputStream fos=null;
            File file=new File("F:/test/a//");
            checkFile(file);

            file.createNewFile();

            byte[] bytes=new byte[INT];
            int count=1;
            int length=0;

            while ((length=fis.read(bytes))!=-1){
                fos=new FileOutputStream(file.getAbsolutePath()+(count++)+".mp4");
               fos.write(bytes,0,length);
                fos.close();

            }
            fis.close();
            IOStream8.recorveryFile(file,"a.mp4");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkFile(File file) throws IOException {
        if(!file.exists()){
            String path=file.getAbsolutePath();
            String parePath=path.substring(0,path.lastIndexOf(File.separator));
            File parP=new File(parePath);
            parP.mkdirs();
            file.createNewFile();
        }
    }
}
