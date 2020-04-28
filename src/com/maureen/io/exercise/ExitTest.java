package com.maureen.io.exercise;

import java.io.*;

/**
 * 从控制台读取输入的数据，输入"exit"才退出
 *  控制台输入：System.in
 *  System类中变量的类型：
 *      static PrintStream err
 *      static InputStream	in (字节流)
 *      static PrintStream	out
 *  需要将字节流转为字符流，可用于将字节流转换为字符流的类：
 *      InputStreamReader、OutputStreamWriter
 */
public class ExitTest {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try{
            String str = "";
            while(!str.equals("exit")) {
                str = bufferedReader.readLine();
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
