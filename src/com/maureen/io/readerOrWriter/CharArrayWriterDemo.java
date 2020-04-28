package com.maureen.io.readerOrWriter;

import java.io.CharArrayWriter;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write(97);
        charArrayWriter.write(98);
        charArrayWriter.write(99);
        System.out.println(charArrayWriter); //打印出来abc
        charArrayWriter.close();
    }
}
