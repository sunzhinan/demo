package com.example.demo.basis.string;

/**
 * @author: sunzhinan
 * @create: 2021-10-30 08:49
 * @description: 大小写判断
 */
public class TestString01 {
    public static void main(String[] args) {

        int a = (int)'a';
        int z = (int)'z';

        System.out.println(a);
        System.out.println(z);

        int A = (int)'A';
        int Z = (int)'Z';
        System.out.println(A);
        System.out.println(Z);

        String str1 = "adsdASDS".toUpperCase();
        String str2 = "ADSDsddd".toLowerCase();
        System.out.println(str1);
        System.out.println(str2);

    }
}
