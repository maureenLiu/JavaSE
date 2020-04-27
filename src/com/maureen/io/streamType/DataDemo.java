package com.maureen.io.streamType;

import java.io.*;

/**
 * 写入和读取的数据类型的顺序必须一致，否则读不出来
 * abc.txt中可以看到并不是写入的数据，是因为经过了序列化
 */
public class DataDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;

        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            //向文件中写入数据流
            fileOutputStream = new FileOutputStream("abc.txt");
            dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(123);
            dataOutputStream.writeShort(344);
            dataOutputStream.writeDouble(3.14);
            dataOutputStream.writeUTF("www.maureen.com教育");
            //从文件中读取数据流
            fileInputStream = new FileInputStream("abc.txt");
            dataInputStream = new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readShort());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
