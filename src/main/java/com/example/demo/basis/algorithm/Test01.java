package com.example.demo.basis.algorithm;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 14:14
 * @description: 如何把一个int类型的数，提取出它二进制最右侧的1来
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 6584;
        /**
         * 6584 ： 1100110111000
         * 首先取反得到：0011001000111
         * 将这个值加1得到：0011001001000
         * 再 & 运算得到：0000000001000
         */
        int j = i&(~i+1);
        System.out.println(j);


        System.out.println(13^77);
        System.out.println(20|32);
    }
}
