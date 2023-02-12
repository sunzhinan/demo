package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 13:58
 * @description: 一个数组中，只有一个值出现了奇数次，其他都是出现偶数次，找出这个数
 */
public class TestOddNumber {
    public static int[] arr = {2,5,6,5,5,6,2};
    public static void main(String[] args) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            //我们这边拆解开来就是：0^2^5^6^5^5^6^2;根据结合律得到：0^2^2^6^6^5^5^5；再细化0^(2^2)^(6^6)^(5^5)^5
            //根据n^n = 0 和 0^n = n 可以得到 0^5，所以最后得到的这个值就是那个出现奇数次的值
            k = k ^ arr[i] ;
        }
        System.out.println(k);
    }
}
