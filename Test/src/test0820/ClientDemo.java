package test0820;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class ClientDemo {
    public static void main(String[] args) {
        //1.socket
        Socket socket=null;
        BufferedReader br=null;
        PrintWriter pw=null;
        try {
            //当socket对象建立成功时已经与服务端建立好连接
            socket=new Socket("127.0.0.1",ServerDemo.PORT);
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
           //用于从控制台获取
            BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Enter Something Send To Server");
                String str=br2.readLine();
                System.out.println(str);
                //发送给服务端

                pw.println(str);
                pw.flush();
                //接收


                String temp=br.readLine();
                if(temp.equals("Bye")){
                    pw.print("Bye");
                    break;
                }

                Logger.getGlobal().info("Server Send Message:\t"+temp);
                pw.println("你好！");
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
