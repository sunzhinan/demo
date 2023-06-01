package com.example.demo.algorithm.study;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-05-30 22:19
 * @description: 冒泡排序
 */
public class Study001 {
    public static void main(String[] args) {
        int[] arrays1 = {4,6,2,5,7,9,1,8,3};
//        fun1(arrays1);
        int[] arrays2 = {4,6,2,3,7,5,1,8,9};
        fun2(arrays2);
        int[] arrays3 = {4,6,2,3,7,5,1,8,9};
        fun2(arrays3);
    }

    public static void fun1(int[] arrays){
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * 冒泡排序
     */
    public static void fun2(int[] arrays){
        // 记录排序过程中比较次数
        int count = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - i -1; j++) {
                if (arrays[j] > arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                }
                count++;
            }
        }
        System.out.print("冒泡排序结果 ： ");
        System.out.print(Arrays.toString(arrays));
        System.out.println("  比较次数 ： " + count + "次");
    }

    /**
     * 冒泡排序
     */
    public static void fun3(int[] arrays){
        // 记录排序过程中比较次数
        int count = 0;
        for (int i = 0; i < arrays.length - 1; i++) {
            boolean flag =true;
            for (int j = 0; j < arrays.length - i -1; j++) {
                if (arrays[j] > arrays[j+1]){
                    int temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                    flag = false;
                }
                count++;
            }
            if (flag){
                break;
            }
        }
        System.out.print("冒泡排序优化结果 ： ");
        System.out.print(Arrays.toString(arrays));
        System.out.println("  比较次数 ： " + count + "次");
    }
}
