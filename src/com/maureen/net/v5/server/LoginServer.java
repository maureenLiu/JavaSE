package com.maureen.net.v5.server;

import com.maureen.net.v4.client.User;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(10000);
        //while死循环使得服务器端不关
        while(true) {
            Socket server = serverSocket.accept();
            //获取输入流对象
            InputStream inputStream = server.getInputStream();
            //需要使用ObjectInputStream对象
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User)objectInputStream.readObject();
            String str = "";
            if("maureen".equals(user.getUsername()) && "maureen".equals(user.getPassword())) {
                System.out.println("欢迎你：" + user.getUsername());
                str = "登录成功";
            } else {
                str = "登录失败";
            }
            //截断输入流
            server.shutdownInput();
            //给客户端响应
            DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
            outputStream.writeUTF(str);
            server.shutdownOutput();
            //关闭流操作
            outputStream.close();
            inputStream.close();
            server.close();
        }
        //serverSocket.close();
    }
}
