package com.maureen.io.exercise;

import java.io.*;

/**
 * 要求：从控制台读取输入的数据，输入"exit"才退出
 *  控制台输入：System.in
 *  控制台输出：System.out
 *  System类中变量的类型：
 *      static PrintStream err
 *      static InputStream	in (字节流)
 *      static PrintStream	out
 *  需要将字节流转为字符流，可用于将字节流转换为字符流的类：InputStreamReader、OutputStreamWriter
 *
 *  创建多个流对象的时候，关闭就很麻烦，有个简单的方法：将创建流的操作放到try()的括号中，就不需要再关闭流了
 *
 */
public class ExitTest2 {
    public static void main(String[] args) {
        try(InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);){

            String str = "";
            while(!str.equals("exit")) {
                str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
