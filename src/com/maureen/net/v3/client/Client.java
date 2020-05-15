package com.maureen.net.v3.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //创建图片的输入流对象
        FileInputStream fileInputStream = new FileInputStream("xz.jpg");
        //创建Socket
        Socket client = new Socket("localhost", 10086);
        //获取输出流对象
        OutputStream outputStream = client.getOutputStream();
        int temp = 0;
        while((temp = fileInputStream.read()) != -1) {
            outputStream.write(temp);
        }
        //添加流输出完成的标志
        client.shutdownOutput();
        //接收服务端的响应
        InputStream inputStream = client.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println(new String(buf, 0, length));
        //添加流输出完成的标志
        client.shutdownInput();
        //关闭流操作
        inputStream.close();
        outputStream.close();
        client.close();
        fileInputStream.close();
    }
}
