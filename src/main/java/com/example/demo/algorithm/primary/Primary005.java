package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 13:10
 * @description: leetcode_初级算法
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class Primary005 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a = a ^ i;
        }
        return a;
    }
}
