package com.example.demo.hw;

import java.util.ArrayList;

/**
 * 【字符串变换最小字符串】给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串(按照字典序进行比较)。变化规则:交换字符串中任意两个不同位
 *
 */
public class Test001 {

    /**
     * 很简单，只要进行一次选择排序
     * @param str
     * @return
     */
    private static String fun(String str){
        char [] strArray = str.toCharArray();
        for (int i = 0 ;i<str.length()-1;i++){
            int index = i;
            for (int j = i+1; j < str.length(); j++) {
                if(strArray[j]< strArray[index]){
                    index = j;
                }
            }
            if(i != index){
                char s = strArray[i];
                strArray[i] = strArray[index];
                strArray[index] = s;
                return new String(strArray);
            }
        }
        return str;
    }

    private static String fun2(String str){
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length-1; i++) {
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[index]){
                    index = j;
                }
            }

            if(i != index){
                char s = array[i];
                array[i] = array[index];
                array[index] = s;
                return new String(array);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "fbcade";
        System.out.println(fun(str));
        System.out.println("----------------");
        System.out.println(fun2(str));

    }
}
