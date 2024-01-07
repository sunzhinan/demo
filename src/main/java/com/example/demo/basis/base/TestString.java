package com.example.demo.basis.base;

/**
 * @author: sunzhinan
 * @create: 2023-08-30 21:20
 * @description:
 */
public class TestString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a" + "b";
        System.out.println(s1==s2);

        String s3 = new String("ab");
        System.out.println(s1 == s3);
    }
}
