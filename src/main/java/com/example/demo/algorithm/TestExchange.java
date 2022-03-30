package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 13:42
 * @description: 通过不定义额外变量来交互两个数的值
 */
public class TestExchange {

    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        //这里只要记住：a^b^a = b; a^b^b = a;所以我们得到a^b后，只要将这个数分别^a或者^b，就可以的a和b
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("a的值为" + a);
        System.out.println("b的值为" + b);
    }
}
