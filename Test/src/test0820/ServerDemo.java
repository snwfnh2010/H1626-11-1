package test0820;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * 服务端
 * Created by snwfnh on 2016/8/20.
 */
public class ServerDemo {
    //0-65535之间任意一个数，每一个应用启动后都会占用一个端口，前100个不推荐
    public static final int PORT=1111;
    public static void main(String[] args) {
        //1.创建ServerSocket对象
        ServerSocket ss=null;
        //2.创建一个Socket对象
        Socket socket=null;
        //3.提供流对象
        BufferedReader br=null;
        PrintWriter pw=null;
        BufferedReader br2=null;



        try {
            //实例化ServerSocket
            Logger.getGlobal().info("服务端已经启动");
            ss=new ServerSocket(PORT);
            //等待客户端的连接
            socket=ss.accept();//accept方法是阻塞的。
            Logger.getGlobal().info("已有客户端绑定，绑定的客户端IP为"+socket.getInetAddress());
            //接收客户端发过来的启动
            //socket.getInputStream
            //
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            br2=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String temp=br.readLine();
                if(temp!=null&&temp.equals("Bye"))
                    break;
                System.out.println("Client Send Message:\t"+temp);
                System.out.println("Client Send Message:\t");
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
                ss.close();//最后关闭服务端一定要先解除连接，
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
