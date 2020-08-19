package com.example.demo.basis.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sunzhinan
 * @create: 2020-07-29 20:50
 * @description: Stream方法介绍
 */
public class TestStream03 {

    public static List<TestObject> list = new ArrayList<>();

    static {
        list.add(new TestObject("a",4));
        list.add(new TestObject("b",25));
        list.add(new TestObject("c",51));
        list.add(new TestObject("d",23));
    }

    /**
     * 获得新的集合
     */
    public static void getCollection(){
        list.stream().filter((x) -> x.getAge() >= 25).collect(Collectors.toList()).forEach(x-> System.out.println(x.getAge()));

    }

    public static void main(String[] args) {
        getCollection();
    }
}
