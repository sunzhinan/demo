package com.example.demo.basis.jvm;

/**
 * @author: sunzhinan
 * @create: 2020-08-04 20:36
 * @description:
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println(B.k);
    }
}

class A {
    public static int i = 2;

    static{
        i = 3;
    }
}
class B extends A{
    public static  int k = i;
}
