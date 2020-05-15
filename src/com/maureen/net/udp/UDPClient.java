package com.maureen.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        //创建UDP通信的socket
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        //从控制台读取数据
        System.out.println("请输入要传输的信息:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //创建数据报包对象
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length,
                                                            InetAddress.getByName("localhost"), 10001);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
