package com.maureen.generic;

public class MainGenericDemo {
    public static void main(String[] args) {
        //============泛型类=========================
        GenericClass<String> gen1 = new GenericClass<>();
        gen1.setId(1);
        gen1.setT("maureen");
        gen1.show();

        GenericClass<Integer> gen2 = new GenericClass<>();
        gen2.setId(2);
        gen2.setT(100);
        gen2.show();

        GenericClass<Person> gen3 = new GenericClass<>();
        gen3.setId(3);
        gen3.setT(new Person("maureen", 22));
        gen3.show();

        //============泛型接口=========================
        //泛型接口实现方式1的使用：随便决定什么类型都可
        GenericInterface<String> genInterface = new GenericInterfaceSub<>();
        genInterface.test2("abc");
        GenericInterface<Integer> genericInterface = new GenericInterfaceSub<>();
        genericInterface.test2(123);
        //泛型接口实现方式2的使用：因为子类实现的时候已经定义了父类的泛型类型，所以此处test2的参数里只能传String类型
        GenericInterfaceSub2 generic = new GenericInterfaceSub2();
        generic.test2("hello");

        //============泛型方法=========================
        GenericMethod<String> method = new GenericMethod<>();
        method.setT("ttt");
        method.show(123);
        method.show(true);
    }
}
