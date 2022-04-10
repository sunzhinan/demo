package com.example.demo.hw;

/**
 * @author: sunzhinan
 * @create: 2022-04-10 23:31
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        String str = "ZZZe";
        char[] chars = str.toCharArray();
        int a = 0;
        for (int i = 0 ;i < chars.length ; i++){
            a = a + chars[i];
        }
        System.out.println(a);
    }
}
