package com.maureen.io.readerOrWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符流可以直接读写中文汉字，而字节流在处理的时候会出现中文乱码
 */
public class ReaderDemo {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int read = reader.read(); //读取的是一个字符
            System.out.println((char)read);
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
