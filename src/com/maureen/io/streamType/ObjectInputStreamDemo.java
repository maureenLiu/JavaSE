package com.maureen.io.streamType;

import java.io.*;

/**
 * ObjectInputStream反序列化先前使用ObjectOutputStream编写的原始数据和对象
 *
 * 如果在Person类中没有声明serialVersionId就会出现异常：
 *  java.io.InvalidClassException: com.maureen.io.streamType.Person; local class incompatible: stream classdesc serialVersionUID = 5502078067372442869, local class serialVersionUID = 7760794751104251471
 */

public class ObjectInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("111.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readUTF());
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
