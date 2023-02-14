package com.example.demo.algorithm.primary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: sunzhinan
 * @create: 2023-02-13 22:17
 * @description: leetcode_初级算法题
 */
public class Primary009 {

    public static int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[2];

        HashMap<Integer, List> map = new HashMap<Integer, List>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList list = new ArrayList(16);
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]).size() == 1 && target - nums[i] != nums[i]) {
                newNums[0] = i;
                newNums[1] = (int) map.get(target - nums[i]).get(0) != i ? (int) map.get(target - nums[i]).get(0) : (int) map.get(target - nums[i]).get(1);
                break;
            } else if (target - nums[i] == nums[i] && map.get(nums[i]).size() > 1) {
                newNums[0] = i;
                newNums[1] = (int) map.get(nums[i]).get(1);
                break;
            }
        }

        return newNums;
    }

    /**
     * 官方答案
     * @param nums
     * @param target
     * @return
     */
    public static int[] answser1(int[] nums, int target){
        int[] newNums = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                newNums[0] = map.get(target-nums[i]);
                newNums[1] = i;
                break;
            }
            map.put(nums[i] ,i);
        }
        return newNums;
    }

    /**
     * 官方答案
     * @param nums
     * @param target
     * @return
     */
    public static int[] answser2(int[] nums, int target){
        int[] newNums = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    newNums[0] = i;
                    newNums[1] = j;
                }
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(answser1(nums, target)));
    }
}
