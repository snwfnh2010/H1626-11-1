package test0822;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by snwfnh on 2016/8/22.
 */
public class ThreadedEchoHandler implements Runnable {
    private Socket socket;

    public ThreadedEchoHandler(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            Scanner in=new Scanner(is);
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("Hello! Enter BYE to exit.");
            boolean done=false;
            while (!done&&in.hasNextLine()){
                String line=in.nextLine();
                pw.println("Echo: "+line);
                if(line.trim().equals("BYE"))
                    done=true;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
