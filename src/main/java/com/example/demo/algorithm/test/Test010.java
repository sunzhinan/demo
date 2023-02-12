package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-05 15:10
 * @description: 二分法
 */
public class Test010 {

    /**
     * 找到数组中，是否存在num，如果存在返回下标，如果不存在，返回-1
     * @param array 数组
     * @param num 目标值
     * @return 下标
     */
    private static int fun(int[] array, int num){
        if(array == null){
            return -1;
        }
        if(array.length == 1){
            return array[0] == num ? 0 : -1;
        }

        int length = array.length;
        int left = 0;
        int right = length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (array[mid] == num){
                return mid;
            }else if(array[mid] < num){
                left = mid +1;
            }else if(array[mid] > num){
                right = mid-1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] array = {13,24,33,44,55,56,67,78};
        System.out.println(fun(array,44));
    }
}
