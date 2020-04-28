package com.maureen.io.readerOrWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 结果打印到123.txt中
 */
public class PrintStreamTest2 {
    public static void main(String[] args) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream("123.txt"));
            printStream.write("hello,maureen".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.close();
    }
}
