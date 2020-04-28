package com.maureen.io.exercise;

import java.io.*;
import java.net.URL;

/**
 * 通过IO流访问百度，并获取数据(从网站获取源代码信息）
 */
public class BaiduTest {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"))); //项目目录下生成baidu.html文件

            String msg = null;
            while((msg= bufferedReader.readLine()) != null) {
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
