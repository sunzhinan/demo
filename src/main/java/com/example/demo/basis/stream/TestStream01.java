package com.example.demo.basis.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: sunzhinan
 * @create: 2020-07-29 20:10
 * @description: 获得Stream流的方式
 */
public class TestStream01 {

    /**
     * 通过数组获得流
     */
    public static void getStream1(){
        String[] strs1 = {"1","2","8","6","9","5"};
        Stream<String> stream1 = Stream.of(strs1);
        stream1.forEach(System.out::println);

        String str = "fdsfsdf";
        Stream<String> str1 = Stream.of(str);
        str1.forEach(System.out::println);
    }

    /**
     * 通过list获得流
     */
    public static void getStream2(){
        List<String> list = Arrays.asList("a","b","t","r","b");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);
    }

    /**
     * 通过generate获得流，注意配合limit使用
     */
    public static void  getStream3(){
        Stream<String> generate = Stream.generate(() -> "sssfd");
        generate.limit(5).forEach(System.out::println);
    }

    /**
     * 通过iterate方法获得流，注意配合limit使用
     */
    public static void getStream4(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(30).forEach(System.out::println);
    }

    /**
     * 其他方法
     */
    public static void getStream5(){
        String str = "fhggsdf";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);
    }

    public static void main(String[] args) {
        getStream1();
        System.out.println("----------");
        getStream2();
        System.out.println("----------");
        getStream3();
        System.out.println("----------");
        getStream4();
        System.out.println("----------");
        getStream5();
    }
}
