package com.example.demo.basis.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sunzhinan
 * @create: 2020-07-29 20:47
 * @description: Stream方法介绍
 */
public class TestStream02 {

    public static List<Integer> list = Arrays.asList(25,7,21,35,47,15,568,45,42,56,68,54,15,7,9,35,45);

    /**
     * filter方法使用示例
     */
    public static void filter1(){
        //找出大于30的数字
        list.stream().filter((x) -> x>30).forEach(System.out::println);

        System.out.println("--------");

        //找出大于30的数字，并求和
        int sum = list.stream().filter((x) -> x > 30).mapToInt(x -> x).sum();
        System.out.println(sum);

        System.out.println("--------");
    }

    /**
     * 最大值与最小值
     */
    public static void maxAndMin(){
        //集合中最大值——方法一
        int max = list.stream().max(Comparator.comparingInt(a -> a)).get();
        System.out.println(max);

        System.out.println("--------");

        //集合中最大值——方法二
        Integer max1 = list.stream().sorted((a,b)->b-a).findFirst().get();
        System.out.println(max1);

        System.out.println("--------");

        //最小值一
        int min = list.stream().min(Comparator.comparingInt(a -> a)).get();
        System.out.println(min);

        System.out.println("--------");

        //最小值二
        Integer min1 = list.stream().sorted().findFirst().get();
        System.out.println(min1);
    }

    /**
     * find方法介绍
     */
    public static void findMethod(){
        int i = list.stream().filter((x) -> x < 50).findAny().get();
        System.out.println(i);
    }

    /**
     * 去重
     */
    public static void distinct(){
        System.out.println("----1----");
        list.stream().distinct().forEach(System.out::println);

        System.out.println("----2----");
        list.stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("----3----");
        new HashSet<>(list).forEach(System.out::println);
    }

    public static void main(String[] args) {
        filter1();
        maxAndMin();
        findMethod();
        distinct();

    }
}
