package com.example.demo.algorithm.primary;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: sunzhinan
 * @create: 2023-02-05 13:21
 * @description: leetcode_初级算法
 * <p>
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 进阶：
 * 1、如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 2、如果nums1的大小比nums2 小，哪种方法更优？
 * 3、如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Primary006 {
    public static int[] inersect(int[] nums1, int[] nums2) {
        int length = Math.min(nums1.length, nums2.length);
        int[] nums = new int[length];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.get(nums1[i]) == null ? 1 : map.get(nums1[i]) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) - 1 >= 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                nums[index] = nums2[i];
                index++;
            }
        }
        return Arrays.copyOfRange(nums, 0, index);
    }

    /**
     * 这个是官方答案：有序数组+双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] function(int[] nums1, int[] nums2) {
        // 先将数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length = Math.min(nums1.length, nums2.length);
        int[] nums = new int[length];
        int index = 0;
        int left = 0;
        int right = 0;

        while (left<nums1.length && right < nums2.length){
            if (nums1[left] == nums2[right]) {
                nums[index++] = nums1[left];
                left++;
                right++;
                continue;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else {
                left++;
            }
        }

        return Arrays.copyOfRange(nums, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(inersect(nums1, nums2)));
    }
}
