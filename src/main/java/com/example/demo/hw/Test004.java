package com.example.demo.hw;

/**
 * 【字符串分割】给定非空字符在s，将该字符串分割成一些子串，使每个子串的ASCIIA码值的和均为水仙花数。
 *
 * 补充：水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身。
 *
 *
 * 输入  abc
 * 输出  0
 */
public class Test004 {

    private static int fun(String str){
        // 遍历，相加，得到的数值调用isNum方法判断是否是水仙花数即可
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length-1; i++) {
            int a = c[i];
            int k = a;
            for (int j = i+1; j < c.length; j++) {
                int b = c[j];
                k = k + b;
                if (k < 999  && isNum(k)){
                    return k;
                }
            }
        }
        return 0;
    }

    /**
     * 判断是否是水仙花数
     * 371=3^3+7^3+1^3
     * @param num
     */
    private static boolean isNum(int num){
        int a = num%10;
        int b = num/10%10;
        int c = num/100%10;
        if((a*a*a + b*b*b + c*c*c) == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 校验判断是否为水仙花数方法是否正确
        System.out.println(isNum(371));
        System.out.println(isNum(370));
        System.out.println(isNum(375));

        System.out.println("-------------");

        System.out.println(fun("abc"));
    }
}
