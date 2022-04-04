package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 00:27
 * @description: 插入排序
 */
public class Test006 {

    private static void fun(int[] array){
        if(array == null || array.length < 2){
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int index = i;
            // 这里只要将array[index-1] > array[index] 改成array[index-1] < array[index] 就是由大到小
            while (index-1 >= 0 && array[index-1] > array[index]){
                array[index] = array[index]^array[index-1];
                array[index-1] = array[index]^array[index-1];
                array[index] = array[index]^array[index-1];
                index--;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {34,3,45,76,24,67,34,23,56};
        fun(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
    }
}
