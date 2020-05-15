package com.maureen.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            //获取主机名和IP地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            //根据主机名获取IP地址
            InetAddress inetAddr = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddr);
            System.out.println(inetAddr.getHostAddress());
            System.out.println(inetAddr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
