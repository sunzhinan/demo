package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-04 23:14
 * @description: leetcode_初级算法
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class Primary001 {

    public static int function(int[] nums){
        int length = nums.length;
        if (length == 0 || length == 1){
            return length;
        }
        int left = 0;
        int right = 1;
        for (int i = 0; i < length-1; i++) {
            if(nums[left] != nums[right]){
                int k = nums[left+1];
                nums[left + 1] = nums[right];
                nums[right] = k;
                // 注意：这里不能使用a^b^b = a 这种思想，因为如果是两个靠近位置数字就会有问题
                left++;
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3} ;
//        int[] nums = {1,1,1,1,2};
        int[] nums = {0,1,1,2,2,3,4,5,5};
        int length = function(nums);

        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}
