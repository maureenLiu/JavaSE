package com.maureen.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    //通过数组来生成Stream对象
    static void gen1() {
        String[] strs = {"a","b","c","d","e"};
        //数组转成Stream对象
        Stream<String> strs1 = Stream.of(strs);
        //遍历
        strs1.forEach(System.out::println);
//        for(String str: strs) {
//            System.out.println(str);
//        }
    }

    //通过集合来生成
    static void gen2() {
        List<String> list = Arrays.asList("1","2","3","4");
        //List转成Stream对象
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //通过Stream.generate方法来创建
    static void gen3() {
        //输出1
        Stream<Integer> generate = Stream.generate(() -> 1);
        //输出没有个数限制
        //generate.forEach(System.out::println);
        //限制输出的个数为10个
        generate.limit(10).forEach(System.out::println);
    }

    //使用Stream.iterate
    static void gen4() {
        //输出1~10，第二个参数是函数式接口
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    //其他方式
    static void gen5() {
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //Stream的生成操作
        gen1();
        gen2();
        gen3();
        gen4();
        gen5();

        //中间操作：如果调用方法之后返回的结果是Stream对象，就意味着是一个中间操作
        Arrays.asList(1,2,3,4,5).stream() //转成流对象
                .filter((x)->x%2==0) //取出偶数
                .forEach(System.out::println); //遍历输出

        //终止操作
        //求出结果集中所有偶数的和  count表示结果有多少个元素
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)//转换为IntStream;
                .sum();
        System.out.println(sum);

        //求集合中的最大值
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());

        //求集合中的最小值
        System.out.println(list.stream().min((a, b) -> a - b).get());

        //取出结果集中的任何一个数
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());
        //取出结果集中的第一个数
        Optional<Integer> first = list.stream().filter(x -> x % 10 == 6).findFirst();
        System.out.println(first.get());

        Stream<Integer> integerStream = list.stream().filter(i -> {
            //如果只是输出integerStream,这段代码不会得到执行，因为只有执行终止算子的时候才会执行，否则中间操作是不会执行的、
            //“运行代码"会执行两次，因为是将集合中的数一个一个地使其进入filter中，满足条件后就返回不继续往下执行了。
            //也就是说，这里先是数1进入了filter中，打印出“运行代码”,但是不是偶数，所以继续往下执行；
            //然后2进入filter中，打印出“运行代码”，是偶数就直接返回，不再往下继续执行
            System.out.println("运行代码");
            return i % 2 == 0;
        });
        //在遇到终止操作之前，中间操作不执行，是为了节省空间，减少中间结果的存储
        System.out.println(integerStream.findFirst().get());

        System.out.println("-------------------------------");
        //获取最大值和最小值，但是不使用min和max函数
        Optional<Integer> min = list.stream().sorted().findFirst();
        System.out.println(min.get());
        Optional<Integer> max2 = list.stream().sorted((a, b) -> b - a).findFirst();
        System.out.println(max2.get());
        //字符串排序 --自然序(字典序)
        Arrays.asList("java", "c#", "python", "scala").stream().sorted().forEach(System.out::println);
        //字符串排序 -- 按照字符串长度排序
        Arrays.asList("java", "c#", "python", "scala").stream().sorted((a,b)->a.length() - b.length()).forEach(System.out::println);

        //将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("-------------------------------");
        //去重操作
        Arrays.asList(1,2,3,3,3,4,5,2).stream().distinct().forEach(System.out::println);
        System.out.println("-------------------------------");
        Arrays.asList(1,2,3,3,3,4,5,2).stream().collect(Collectors.toSet()).forEach(System.out::println);

        //打印20-30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);

        //求和
        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        //将str中的每一个数值都打印出来，同时算出最终的求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        //创建一组自定义对象
        String str2 = "java, scala, python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //输出所有匹配的结果
        System.out.println(list.stream().allMatch(x->x>=0));
    }
}
