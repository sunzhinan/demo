package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 00:44
 * @description: leetcode_初级算法第三题
 */
public class Primary003 {

    /**
     * 方法一：存在缺陷，执行效率差
     * @param nums
     * @param k
     */
    public static void functionOne(int[] nums, int k) {
        int index = k % nums.length;
        if (index == 0) {
            return;
        }

        for (int i = 0; i < index; i++) {
            /**
             * 思路
             int a = nums[0];
             nums[0] = nums[1];
             nums[1] = a;

             int b = nums[0];
             nums[0] = nums[2];
             nums[2] = b;

             int c = nums[0];
             nums[0] = nums[3];
             nums[3] = c;
             */
            for (int j = 1; i < nums.length; j++) {
                int d = nums[0];
                nums[0] = nums[j];
                nums[j] = d;
            }
        }

        return;
    }

    /**
     * 方法二
     * @param nums
     * @param k
     */
    public static void functionTwo(int[] nums, int k) {
        int n = k % nums.length;
        if (n == 0) {
            return;
        }
        changeNums(nums, 0, nums.length - 1);
        changeNums(nums, 0, n - 1);
        changeNums(nums, n, nums.length - 1);
    }

    public static void changeNums(int[] nums, int start, int end) {
        while (start < end) {
            int a = nums[start];
            nums[start] = nums[end];
            nums[end] = a;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 8;
//        functionOne(nums, k);
        functionTwo(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}
