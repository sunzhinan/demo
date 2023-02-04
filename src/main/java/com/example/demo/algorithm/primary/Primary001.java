package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-04 23:14
 * @description: leetcode-初级算法第一题
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
