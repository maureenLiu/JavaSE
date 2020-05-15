package com.maureen.net.v2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10000);
        //获取服务端的套接字对象
        Socket server = serverSocket.accept();

        //----------------接收客户端发送的消息-------------
        //获取输入流对象
        InputStream inputStream = server.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("客户端传输的数据是:" + new String(buf, 0, length));

        //----------------给客户端发送消息------------
        //获取输出流对象
        OutputStream outputStream = server.getOutputStream();
        outputStream.write("Hello,Client, I'm Server".getBytes());

        //关闭流对象
        outputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
