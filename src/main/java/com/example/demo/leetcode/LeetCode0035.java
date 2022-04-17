package com.example.demo.leetcode;

/**
 * @author: sunzhinan
 * @create: 2022-04-11 22:31
 * @description: leetcode第35题
 */
public class LeetCode0035 {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1 && (nums[0] == target || nums[0] > target)) {
            return 0;
        }

        if (nums.length == 1 && nums[0] < target) {
            return 1;
        }

        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return left;
    }


    public static void main(String[] args) {
        int[] arrays = {1, 3, 5, 6, 7, 8};
        int target = 0;
        System.out.println(searchInsert(arrays, target));
    }
}
