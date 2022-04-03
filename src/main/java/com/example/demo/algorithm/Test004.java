package com.example.demo.algorithm;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: sunzhinan
 * @create: 2021-10-30 09:49
 * @description:
 */
public class Test004 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3};

        int[] arr = new int[2];
        int k = 0;
        for(int i = 0 ; i< nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                System.out.println(nums[i]);
                System.out.println(nums[j]);
                System.out.println(nums[i] ^ nums[j]);
                System.out.println("---------");

                if((nums[i] ^ nums[j]) != 0){
                    System.out.println("********");
                    System.out.println(nums[i]);
                    System.out.println("********");
                    arr[k] = nums[i];
                    k++;
                }
            }
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);


        AtomicBoolean second = new AtomicBoolean(false);

        System.out.println(second.get());
    }
}
