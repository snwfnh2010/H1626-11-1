package test0822;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by snwfnh on 2016/8/22.
 */
public class MultiDownload {
    public static int threadCount=4;
    public static void main(String[] args) {
        try {
            String path="http://file.mydrivers.com/DG2015Setup_1223B.exe";
            URL url=new URL(path);
            URLConnection conn=url.openConnection();
            //获取文件的长度。
            int length=conn.getContentLength();
            RandomAccessFile raf=new RandomAccessFile("F:\\test\\DG2015Setup.exe","rw");
            raf.close();
            //获取每个线程下载文件的大小
            int eachSize=length/threadCount;
            for (int i=1;i<=threadCount;i++){
                int start=(i-1)*eachSize;
                int end=eachSize-1;
                if(i==threadCount){
                    end = length;
                }
                System.out.println("线程"+i+"下载"+start+"--"+end);
                new DownloadThread(i,start,end,path).start();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadThread extends Thread {
        private int i;
        private int start;
        private int end;
        private String path;

        public DownloadThread(int i, int start, int end, String path) {
            this.i = i;
            this.start = start;
            this.end = end;
            this.path=path;
        }

        @Override
        public void run() {
            try {
                URL url=new URL(path);
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                RandomAccessFile raf=new RandomAccessFile("F:\\test\\DG2015Setup.exe","rw");
                raf.seek(start);
                int length=0;
                byte[] bytes=new byte[1024];
                while (-1!=(length=is.read(bytes))){
                    raf.write(bytes,0,length);

                }
                is.close();
                raf.close();
                System.out.println("线程"+i+"下载完成");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
