package com.example.demo.hw;

/**
 * 特定大小的停车场，数组cars[ ]表示，其中0代表有车，1代表无车，车辆大小不一，统计停车场最少可以停多少辆车，返回具体的数字。长度小于1000
 *
 * 输入：小车占一个车位（长度1），中车占两个车位（长度2），大车占三个车位（长度3）
 *
 * 输出：整形数字字符串，表示最少停车数目
 *
 * eg:
 * 输入：1，1，0，0，1，1，1，0，1
 * 输出：3
 */
public class Test002 {

    private static int fun (String str){
        int num = 0;
        String[] arrayStr = str.split(",");
        StringBuilder stringBuilder= new StringBuilder();
        for(int i =0;i<arrayStr.length;i++){
            stringBuilder.append(arrayStr[i]);
        }
        String[] array = stringBuilder.toString().split("0");

        for(int i = 0;i<array.length;i++){
            int length = array[i].length();
            if(length/3 != 0){
                num = num + length/3;
                length = length%3;
            }
            if (length/2 !=0){
                num = num + length/2;
                length = length%2;
            }
            if (length ==1){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(fun("1,1,0,1,1,1,1,1,0,1,1,0"));
    }
}
