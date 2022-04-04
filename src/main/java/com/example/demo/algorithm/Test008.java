package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 15:50
 * @description: 通过二维数组解决数组随机区间相加的问题
 */
public class Test008 {
    private static int[] array = {2,3,45,32,12,23,66,47,98,23};

    private static int[][] newArray = new int[array.length][array.length];

    private static int fun(int i,int j){
        if (i < 0 || j < 0 || i >= array.length || j >= array.length || j<i){
            return 0;
        }
        return newArray[i][j];
    }

    private static void initNewArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i <= j){
                    if(j == 0){
                        newArray[i][j] = array[j];
                    }else{
                        newArray[i][j] = newArray[i][j-1] + array[j];
                    }
                }else{
                    newArray[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个二维数组，该数组的[i][j]位置是之前数组[i]～[j]位置只和
        initNewArray(array);
        System.out.println(fun(1,3));
        System.out.println(fun(0,3));

        // 如果计算的下标异常，就返回0
        System.out.println(fun(2,1));
    }
}
