package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 00:22
 * @description: 选择排序
 */
public class Test004 {

    private static void fun(int[] array){
        if(array == null || array.length < 2){
            return;
        }

        for (int i = 0; i < array.length -1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]){
                    array[i] = array[j]^array[i];
                    array[j] = array[j]^array[i];
                    array[i] = array[j]^array[i];
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {34,23,45,25,56,12,36,48};
        fun(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
    }
}
