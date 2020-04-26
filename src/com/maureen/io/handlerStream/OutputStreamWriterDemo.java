package com.maureen.io.handlerStream;

import java.io.*;

/**
 * OutputStreamWriter的参数要求是OutputStream，这就是在字节流外又封装了一层，整体当做一个字符流，读取大文件的时候提升了效率
 * 灵活性体现在：可以指定编码格式
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
        OutputStreamWriter outputStreamWriter = null;
        File file = new File("abc.txt");
        FileOutputStream fileOutputStream = null;
        try {
            long start = System.currentTimeMillis();
            fileOutputStream = new FileOutputStream(file);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8"); //可以指定编码格式
            outputStreamWriter.write(99);
            outputStreamWriter.write("教育");
            outputStreamWriter.write("abcdefg",0, 5); //只要求输出5个
            //会在abc.txt文件中写入的内容是: c教育abcde
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流对象的时候，建议按照创建的顺序逆序来进行关闭
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
