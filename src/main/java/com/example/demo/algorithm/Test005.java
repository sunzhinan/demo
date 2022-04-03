package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 00:25
 * @description: 冒泡排序
 */
public class Test005 {

    /**
     * 由小到大
     * @param array
     */
    private static void fun1(int[] array){

        if(array == null || array.length < 2){
            return;
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]){
                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j]^array[j+1];
                    array[j] = array[j]^array[j+1];
                }
            }
        }
    }

    /**
     * 由大到小
     * @param array
     */
    private static void fun2(int[] array){
        if(array == null || array.length < 2){
            return;
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length - 1; j > i ; j--) {
                if(array[j] > array[j-1]){
                    array[j] = array[j]^array[j-1];
                    array[j-1] = array[j]^array[j-1];
                    array[j] = array[j]^array[j-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {34,23,45,25,56,12,36,49};
        fun1(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }

        System.out.println();
        System.out.println("-------");

        fun2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(",");
        }
    }
}
