package com.example.demo.basis.jvm;

/**
 * @author: sunzhinan
 * @create: 2021-01-06 20:37
 * @description: 类加载演示:理解类加载过程
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(D.i);
        System.out.println("----------------");
        System.out.println(E.i);
    }
}

class D{
    public static int i = 2;
    public static D d = new D();

    private D(){
        System.out.println("D.i = " + i );
        i++;
    }
}

class E{
    public static E d = new E();
    public static int i = 2;

    private E(){
        System.out.println("E.i = " + i );
        i++;
    }
}