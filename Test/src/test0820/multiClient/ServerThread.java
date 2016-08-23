package test0820.multiClient;

import java.io.*;
import java.net.Socket;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class ServerThread extends Thread {
    private Socket socket=null;
    private int count=0;

    public ServerThread(Socket socket, int count) {
        this.socket = socket;
        this.count = count;
    }

    @Override
    public void run() {
        BufferedReader br=null;
        PrintWriter pw=null;
        BufferedReader br2=null;
        try {
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            br2=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String temp=br.readLine();
                System.out.println("客户端"+count+":"+temp);
                if(temp!=null&&temp.equals("Bye"))
                    break;
                System.out.println("Enter Return To Client:");
                pw.println(br2.readLine());
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                pw.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
