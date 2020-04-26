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
 */
public class InputStreamDemo3 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0; //表示读取的数据的长度
            //添加缓冲区的方式进行读取，每次读取指定长度的数据
            byte[] buffer = new byte[1024];
            while((length = inputStream.read(buffer,5,5)) != -1) {
                System.out.println(new String(buffer, 5, length));
            }
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
