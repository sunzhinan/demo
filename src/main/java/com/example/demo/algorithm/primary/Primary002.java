package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 00:19
 * @description: leetcode_初级算法第二题
 */
public class Primary002 {
    public static int function(int[] prices){
        int length = prices.length;

        int max = 0;
        for (int i = 0; i < length-1; i++) {
            if ((prices[i+1] - prices[i])>0){
                max = max + prices[i+1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {3};
        System.out.println(function(prices));

    }
}
