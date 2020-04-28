package com.maureen.io.readerOrWriter;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        char[] chars = "教育".toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        try {
            int read = 0;
            while((read = charArrayReader.read()) != -1) {
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }
    }
}
