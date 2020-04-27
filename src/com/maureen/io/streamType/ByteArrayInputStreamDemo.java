package com.maureen.io.streamType;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String str = "www.maureen.com";
        byte[] buffer = str.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        int read = 0;
        while ((read=byteArrayInputStream.read()) != -1) { //读出buffer中的数据
            byteArrayInputStream.skip(4);//输出每隔4个的字符
            System.out.println((char)read); //输出w a n
        }
//        int read = byteArrayInputStream.read();
//        System.out.println((char)read); //输出w
        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
