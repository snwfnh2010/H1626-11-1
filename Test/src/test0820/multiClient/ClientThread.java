package test0820.multiClient;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Enter Something Send To Server");
                String str = br2.readLine();

                System.out.println(str);
                pw.println(str);
                pw.flush();
                String temp=br.readLine();
                Logger.getGlobal().info("服务器返回消息:\t"+temp);
                br.close();
                pw.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

