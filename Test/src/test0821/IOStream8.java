package test0821;

import java.io.*;

/**
 * Created by snwfnh on 2016/8/21.
 */
public class IOStream8 {
    public static void main(String[] args) throws IOException {
      // File file=new File("F:c.txt");
       // spiltFile(file,2);
       File file=new File("F:/test/a/");
       recorveryFile(file,"cc");

    }

    public static boolean spiltFile(File file,int i) throws IOException {
        if(!file.exists()){
            System.out.println("文件不存在");
            return false;
        }if(i<=0){
            System.out.println("切割大小有误");
            return false;
        }
        File reserveFile=new File("F:/test/a/");
        if(!reserveFile.exists()){
            reserveFile.mkdirs();
        }
        InputStream is=new FileInputStream(file);
        int length=0;
        int count=1;
        byte[] bytes=new byte[1024*i];
        while (-1!=(length=is.read(bytes))){
            OutputStream os=new FileOutputStream(new File(reserveFile,(count++)+"part.txt"));
            os.write(bytes,0,length);
            os.close();
        }
        is.close();
        return true;
    }

    public static boolean recorveryFile(File file,String name) throws IOException {
        if(!file.exists()){
            System.out.println("文件不存在");
            return false;
        }

        File recoveryFile=new File("F:/test/");
        if(!recoveryFile.exists()){
            recoveryFile.mkdirs();
        }
        File[] files=file.listFiles();
        for (int i=0;i<files.length;i++){
            File theFile=files[i];
            if(theFile.isFile()){
                byte[] bytes=new byte[1024*1024];
                int length=0;
                InputStream is=new FileInputStream(theFile);
                while (-1!=(length=is.read(bytes))){
                    OutputStream os=new FileOutputStream(new File(recoveryFile,name+".txt"));
                    os.write(bytes,0,length);
                    os.close();
                }
                is.close();

            }
        }
      return true;
    }
}
