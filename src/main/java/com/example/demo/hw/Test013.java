package com.example.demo.hw;

/**
 * 可信二期 19题
 * 字符串比较：给定字符串A、B和正整数V，A的长度与B的长度相等，请计算A中满足如下条件的最大连续子串的长度：
 * 1、该连续字串在A和B中的位置和长度均相同
 * 2、该连续子串|A[i]-B[i]|之和小于等于V。其中|A[i]-B[i]|表示两个字母ASCII码之差的绝对值。
 */
public class Test013 {

    private static int fun(String a , String b , int v){
        int length = a.length();
        int sum = 0;
        int max = 0;
        for (int i = 0;i < length ; i++){
            for (int j = 0; j < length; j++) {
                int k = 2;
                while (i + k <= length && j+k <= length && a.substring(i,i+k).equals(b.substring(j,j+k))){
                    for (int l = 0; l < k; l++) {
                        sum = Math.abs(a.charAt(i+l) -b.charAt(i+l)) + sum;
                    }
                    if (sum <= v && k > max){
                        max = k;
                    }
                    k++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "adsaerqw";
        String b = "adsdsadw";
//        String a = "xxcdefg";
//        String b = "cdefghi";
        int v = 5;
        System.out.println(fun(a,b,v));
    }
}
