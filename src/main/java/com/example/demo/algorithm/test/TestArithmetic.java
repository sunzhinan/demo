package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 13:03
 * @description: java运算符介绍
 */
public class TestArithmetic {

    private static void print(int i){
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 31; j >= 0; j--) {
            stringBuilder.append((i&(1<<j)) == 0? "0" : "1");
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 带符号右移
     */
    public static void test1() {
        int i = -4;
        print(i);
        System.out.println("带符号右移 i : " + (i >> 2));
        print(i>>2);

    }

    /**
     * 不带符号右移
     */
    public static void test2() {
        int i = -4;
        int j = 4;
        System.out.println("不带符号右移 i : " + (i >>> 2));
        System.out.println("不带符号右移 j : " + (j >>> 2));
    }

    /**
     * 左移
     */
    public static void test3() {
        int i = 4;
        System.out.println("左移 i :" + (i << 2));
    }

    /**
     * 异或运算
     */
    public static void test4() {
        int i = 20;
        int j = 32;
        System.out.println("异或运算20^32 结果为 :" + (i^j));
    }

    /**
     * & 运算
     */
    public static void test5() {
        int i = 20;
        int j = 32;
        System.out.println("20&32 结果为 :" + (i&j));
    }

    /**
     * | 运算
     */
    public static void test6() {
        int i = 20;
        int j = 32;
        System.out.println("20|32 结果为 :" + (i|j));
    }

    /**
     * 取反
     */
    public static void test7() {
        int i = 20;
        print(i);
        System.out.println("20取反 结果为 :" + (~i));
        print(~i);
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

}