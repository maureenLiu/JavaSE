package com.maureen.annotation.metaannotation;

import java.lang.annotation.*;

@MyAnnotation
public class MetaAnnotation {
    public void test() {}
}

//用来声明当前自定义的注解适合用于什么地方，类，方法，变量，包.....
@Target({ElementType.METHOD, ElementType.TYPE})
//Retention用来表示当前注解适用于什么环境，是源码级别还是类级别，还是运行时环境，一般都是运行时环境
@Retention(RetentionPolicy.RUNTIME)
//表示该注解是否显示在javadoc中
@Documented
//表示当前注解是否能够被继承
@Inherited
@interface MyAnnotation{

}
