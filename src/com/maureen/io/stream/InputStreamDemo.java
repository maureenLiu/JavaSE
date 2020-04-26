package com.maureen.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 注意：当编写IO流的程序的时候,一定要关闭流
 *  步骤：
 *      1、选择合适的IO流对象
 *      2、创建对象
 *      3、传输数据
 *      4、关闭流对象(占用系统资源(Linux中文件个数是有限制的，每个进程能打开的文件个数也是有限制的))
 *
 *      存在问题：每次只能读取一个字节，效率比较低，需要循环n多次
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int read = 0; //不是表示长度，表示读取的字节所表示的ASCII码的值
            //循环输出所有的字节，每次读取一个字符
            while((read = inputStream.read()) != -1) {
                System.out.print((char)read +" ");//整数转为char
            }
//            int read = inputStream.read();
//            System.out.println((char)read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
