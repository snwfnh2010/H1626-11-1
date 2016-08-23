package test0820.multiClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class Server1 {
    public static final int PORT=1112;
    public static void main(String[] args) {
        ServerSocket ss=null;
        Socket socket=null;
        int count=1;
        Logger.getGlobal().info("服务端"+count+"已启动");
        try {
            ss=new ServerSocket(PORT);

            while (true){
                socket=ss.accept();
                count++;
                ServerThread serverThread=new ServerThread(socket,count);
                serverThread.start();
                Logger.getGlobal().info("已有客户端绑定，绑定的IP地址是"+socket.getInetAddress());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
