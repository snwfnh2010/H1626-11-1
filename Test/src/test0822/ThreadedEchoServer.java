package test0822;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by snwfnh on 2016/8/22.
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {

        try {
            int count=1;
            ServerSocket s=new ServerSocket(1111);
            while (true){
                Socket socket=s.accept();
                System.out.println("Spawning "+count);
                Runnable r=new ThreadedEchoHandler(socket);
                Thread t=new Thread(r);
                t.start();
                count++;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
