package com.example.demo.algorithm.study;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-05-31 20:17
 * @description: 选择排序
 */
public class Study002 {

    public static void main(String[] args) {
        int[] arrays = {5,2,4,8,1,9,3,6};
        fun(arrays);
    }

    public static void fun(int[] arrays){
        int count = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            int left = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[left]){
                    left = j;
                    count++;
                }
            }
            if ( i != left){
                int temp = arrays[i];
                arrays[i] = arrays[left];
                arrays[left] = temp;
            }
        }

        System.out.println(count);
        System.out.println(Arrays.toString(arrays));
    }
}
