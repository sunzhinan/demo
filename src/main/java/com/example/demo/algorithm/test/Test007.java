package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 15:29
 * @description: 通过一维数组解决随机数组区间相加
 */
public class Test007 {
    private static int[] array = {2,3,45,32,12,23,66,47,98,23};

    private static int[] newArray = new int[array.length];

    private static int fun(int i,int j){

        if (i < 0 || j < 0 || i >= array.length || j >= array.length || j<i){
            return 0;
        }
        if(i == 0){
            return newArray[j];
        }
        return newArray[j] - newArray[i-1] ;
    }

    private static void initNewArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                newArray[i] = array[i];
            }else{
                newArray[i] = newArray[i-1] + array[i];
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个数组，该数组的[i]位置是之前数组[0]～[i]位置只和
        initNewArray(array);

        // 那么[i]～[j]位置只和，就是newArray[j] - newArray[i-1],如果i是0，那么就直接是array[j]
        System.out.println(fun(1,3));
        System.out.println(fun(0,3));
    }
}
