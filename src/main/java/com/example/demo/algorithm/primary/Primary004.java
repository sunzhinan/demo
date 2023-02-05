package com.example.demo.algorithm.primary;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 12:12
 * @description: leetcode_初级算法第四题
 */
public class Primary004 {

    public static boolean containsDuplicate(int[] nums) {
        /**
         * 方法一
         */
        // 冒泡排序，再比较，但是这个执行会超时
        // 选择排序，再比较,这个执行会超时也会超时
        //因此选择系统自带的sort排序
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if ((nums[i] ^ nums[i + 1]) == 0) {
//                return true;
//            }
//        }

        /**
         * 方法二
         */
        HashSet<Integer> set = new HashSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(Arrays.toString(nums));

    }
}
