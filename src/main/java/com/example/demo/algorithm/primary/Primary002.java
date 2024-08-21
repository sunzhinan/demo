package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 00:19
 * @description: leetcode_初级算法
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *
 *
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 */
public class Primary002 {
    public static int function(int[] prices){
        int length = prices.length;

        int max = 0;
        for (int i = 0; i < length-1; i++) {
            if (prices[i+1] > prices[i]){
                max = max + prices[i+1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {3};
        System.out.println(function(prices));

    }
}
