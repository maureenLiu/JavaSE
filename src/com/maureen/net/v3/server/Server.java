package com.maureen.net.v3.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端对象，开放端口
        ServerSocket serverSocket = new ServerSocket(10086);
        //创建服务端的Socket对象
        Socket server = serverSocket.accept();
        //获取输入流对象
        InputStream inputStream = server.getInputStream();
        //创建文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("sean.jpg");
        int temp = 0;
        while((temp = inputStream.read()) != -1) {
            fileOutputStream.write(temp);
        }
        //添加流输出完成的标志,传输比较大的数据的时候要进行关闭，否则程序会以为还有数据要传输，流通道一直处于等待数据状态，程序不会停止
        server.shutdownInput();
        //上传图片结束后给予客户端响应
        OutputStream outputStream = server.getOutputStream();
        outputStream.write("上传成功".getBytes());
        //添加流输出完成的标志
        server.shutdownOutput();
        //关闭流操作
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();
    }
}
