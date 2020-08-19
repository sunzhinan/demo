package com.example.demo.basis.string;

/**
 * @author : sun
 * create at:  2020/4/25  18:35
 * @description: String类详细介绍
 */
public class TestString {

    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = "abc";
        String str3 = "abc";

        StringBuilder sb = new StringBuilder("a");
        String str4 = sb.toString();
        sb.append("bc");
        String str5 = sb.toString();


        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str2 == str5);
        System.out.println(str4 == str5);

    }
}
