package test0820.multiClient;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.RandomAccess;
import java.util.logging.Logger;

/**
 * Created by snwfnh on 2016/8/20.
 */
public class Client1 {
    public static void main(String[] args) {

        try {
            Socket socket=new Socket("127.0.0.1",Server1.PORT);
            ClientThread clientThread=new ClientThread(socket);
            clientThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

