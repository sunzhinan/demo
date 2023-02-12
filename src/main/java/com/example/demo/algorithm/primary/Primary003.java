package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 00:44
 * @description: leetcode_初级算法
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k个位置，其中k是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 */
public class Primary003 {

    public static void functionTwo(int[] nums, int k) {
        int n = k % nums.length;
        if (n == 0) {
            return;
        }
        changeNums(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        changeNums(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
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
        int k = 3;
        functionTwo(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
