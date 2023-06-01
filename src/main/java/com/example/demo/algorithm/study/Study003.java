package com.example.demo.algorithm.study;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-05-31 20:30
 * @description: 插入排序
 */
public class Study003 {

    public static void main(String[] args) {
        int[] arrays = {5, 2, 7, 3, 9, 4, 1, 6};
        fun(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void fun(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int index = arrays[i];
            int j = i - 1;
            for (; j >= 0 && index < arrays[j]; j--) {
                arrays[j+1] = arrays[j];
            }
            arrays[j+1] = index;
        }
    }
}
