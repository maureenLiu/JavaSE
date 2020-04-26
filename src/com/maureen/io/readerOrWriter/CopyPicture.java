package com.maureen.io.readerOrWriter;

import java.io.*;

/**
 * 图片复制功能
 * 纯文本可以使用字符流或者字节流来进行复制
 * 而图片，视频等只能使用字节流，字节流是万能的
 */
public class CopyPicture {
    public static void main(String[] args) {
        /**
         * 使用Reader和Writer不能完成图片的复制功能,字符流
         */
//        FileReader reader = null;
//        FileWriter writer = null;
//        try {
//            reader = new FileReader("xz.jpg");
//            writer = new FileWriter("xz2.jpg");
//
//            int length = 0;
//            byte[] bytes = new byte[1024];
//            while((length = reader.read(bytes)) != -1) {
//                writer.write(bytes);
//                writer.flush();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        /**
         * 使用字节流，FileInputStream和FileOutputStream可以实现图片的复制功能
         */
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream("xz.jpg");
            output = new FileOutputStream("xz2.jpg");

            int length = 0;
            byte[] bytes = new byte[1024];
            while((length = input.read(bytes)) != -1) {
                output.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
