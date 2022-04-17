package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2022-03-30 22:33
 * @description: 运算符介绍
 */
public class Test001 {

    /**
     * 位运算实现加法
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(2,3));
    }
}
