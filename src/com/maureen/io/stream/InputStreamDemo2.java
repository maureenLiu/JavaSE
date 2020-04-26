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
public class InputStreamDemo2 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("abc.txt");
            int length = 0; //表示读取的数据的长度
            //添加缓冲区的方式进行读取，每次会将数据添加到缓冲区中，当缓冲区满了之后，一次读取，而不是每一个字节读取
            byte[] buffer = new byte[1024];
            while((length = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
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
