package com.maureen.io.readerOrWriter;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 结果打印到控制台
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        try {
            printStream.write("hello,maureen".getBytes());
            printStream.println(true);
            System.out.println();
            //格式化输出：%s-字符串；%d:整数；%f:浮点数
            System.out.printf("%s--%d---%.2f","abc",123,111.1111);//打印结果：abc--123---111.11
            //如果有错误输出，可以用err，打印结果是红色
            System.err.println("maureen");
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.close();
    }
}
