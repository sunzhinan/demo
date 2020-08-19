package com.example.demo.basis.algorithm;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 14:27
 * @description:一个数组中，有两个值出现了奇数次，其他都是出现偶数次，找出这两个数
 */
public class TestTwoNumber {
    public static int[] arr = {2,5,6,5,5,6,2,3};

    public static void main(String[] args) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            k = k ^ arr[i] ;
        }
        //首先得到的k1是这两个数^的结果
        System.out.println(k);

        //取这个值的原因是在下一次循环的时候判别两个出现奇数次得到数
        //因为那两个出现奇数次的数，一定在这个数最右边出现1的位置上不同
        int m = k&(~k + 1);
        int n = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & m )== 0) {
                n = n^arr[i];
            }
        }
        System.out.println("这两个值为 ： " + n + "  与  " + (n^k));
    }
}
