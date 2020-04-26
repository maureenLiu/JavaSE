package com.maureen.io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("src/abc.txt");
        //创建文件
        try {
            file.createNewFile(); //执行完后会在项目src目录下生成abc.txt文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断文件属性，都会返回boolean类型的值
        file.canExecute();
        file.canRead();
        file.canWrite();
        //判断当前文件是否存在
        System.out.println(file.exists()); //true
        //获取当前文件的名称
        String name = file.getName();
        System.out.println(name); //abc.txt
        //获取文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath); //F:\workspace\eclipseProjects\OO\src\abc.txt
        //获取文件的父路径名称，如果文件的路径只包含文件名称，则显示空；如果File file = new File("abc.txt");那么结果为null
        String parent = file.getParent();
        System.out.println(parent);//src

        try {
            //返回文件绝对路径的规范字符串
            String canonicalPath = file.getCanonicalPath();
            System.out.println(canonicalPath);//F:\workspace\eclipseProjects\OO\src\abc.txt
            //返回操作系统的文件分割符
            System.out.println(File.separator); //打印结果：\
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回文件对象
        File absoluteFile = file.getAbsoluteFile();

        File file2 = new File("D:/maureen.txt");
        //无论当前文件是否存在，只要给定具体的路径都可以返回相应的路径名称
        System.out.println(file2.getAbsolutePath()); //D:\maureen.txt
        //判断文件是否是目录或者目录，如果文件不存在，那么isFile返回也是false
        System.out.println(file2.isDirectory()); //false
        System.out.println(file2.isFile()); //false
        //打印文件系统的所有盘符
        File[] files1 = File.listRoots();
        /**
         * 打印结果：
         * C:\
         * D:\
         * F:\
         */
        for(int i = 0; i<files1.length; i++){
            System.out.println(files1[i]);
        }
        //罗列指定目录下的所有目录
        File file3 = new File("c:/");
        String[] list = file3.list();
        for(String str:list) {
            System.out.println(str);
        }
        //罗列指定目录下的所有目录名称
        System.out.println("-----------------");
        File[] files = file3.listFiles();
        for(File f: files) {
            System.out.println(f);
        }

        File file4 = new File("d:/a");
        //创建单级目录
        file4.mkdir(); //会在d盘创建名称为a的目录
        File file5 = new File("d:/a/b/c");
        //创建多级目录
        file5.mkdirs(); //会在d盘创建a/b/c目录

        System.out.println("==========================");
        //循环遍历输出指定路径中的所有文件的绝对路径
        //使用递归的方式
        printFile(new File("F:/workspace/maureen"));

    }

    /**
     * 文件在遍历的时候，会出现空指针的问题，原因在于当前文件系统受保护，某些文件没有访问权限，此时会报空指针异常。
     * @param file
     */
    public static void printFile(File file) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f: files) {
                printFile(f);
            }
        } else {
            System.out.println("此文件是一个具体的文件，只有一个文件名称:"+file.getAbsolutePath());
        }
    }
}
