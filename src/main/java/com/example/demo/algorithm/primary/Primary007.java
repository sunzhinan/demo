package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 20:39
 * @description: leetcode_初级算法
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 */
public class Primary007 {
    public static int[] plusOne(int[] digits) {

        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                digits[i] = 0;
                continue;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        int[] nums = new int[length+1];
        if (digits[0] == 0){
            nums[0] = 1;
            nums[1] = 0;
            for (int i = 1; i < length; i++) {
                nums[i+1] = digits[i];
            }
            return nums;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
