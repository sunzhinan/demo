package com.example.demo.basis.jvm;

/**
 * @author: sunzhinan
 * @create: 2020-08-04 20:25
 * @description:
 */
public class Test01 {
    public static int i = 10;

    static {

        i = 20;
        j = 30;
    }

    public static int j = 40;

    public static void main(String[] args) {
        System.out.println(Test01.i);
        System.out.println(Test01.j);
    }
}
