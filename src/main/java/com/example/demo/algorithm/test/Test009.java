package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 22:04
 * @description: 对数器
 */
public class Test009 {

    /**
     * 排序算法
     */
    private static void sort1(int[] array){
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index-1 >= 0 && array[index-1] > array[index]){
                array[index] = array[index]^array[index-1];
                array[index-1] = array[index]^array[index-1];
                array[index] = array[index]^array[index-1];
                index--;
            }
        }
    }

    /**
     * 随机生成一个数组
     * @param maxLength 数组最大长度
     * @param maxValue 数组中元素的最大值
     * @return
     */
    private static int[] createArray(int maxLength, int maxValue){
        int length = (int)(Math.random()*maxLength);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int)(Math.random()*maxValue);
        }
        return array;
    }

    /**
     * 校验升序排序结果
     * @param array 有序数组
     * @return 是否是升序
     */
    private static boolean check(int[] array){
        if(array.length < 2){
            return true;
        }
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int maxLength = 100;
        int maxValue = 10000;
        int[] array = new int[maxLength];
        for (int i = 0; i < 1000; i++) {
            array = createArray(maxLength,maxValue);
            sort1(array);
            if(!check(array)){
                System.out.println("排序算法有问题");
            }
        }
    }
}
