package com.maureen.io.stream;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("aaa.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(99); //写入99对应的字符c
            outputStream.write("\r\nmaureen".getBytes());  //"\r\n"是换行
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
