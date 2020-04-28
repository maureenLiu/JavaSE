package com.maureen.io.readerOrWriter;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("123.txt"));
            //每次读取一个字符
            int read = reader.read();
            System.out.println((char)read);
            //每次读取一整行
            String s = reader.readLine();
            System.out.println(s);
            //while循环读取所有文本
            while((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
