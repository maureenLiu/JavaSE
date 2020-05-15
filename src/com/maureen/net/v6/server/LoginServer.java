package com.maureen.net.v6.server;

import com.maureen.net.v4.client.User;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(10000);
        //while死循环使得服务器端不关
        while(true) {
            Socket socket = serverSocket.accept();
            LoginThread loginThread = new LoginThread(socket);
            new Thread(loginThread).start();
        }
        //serverSocket.close();
    }
}
