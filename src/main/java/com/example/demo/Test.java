package com.example.demo;

/**
 * @author: sunzhinan
 * @create: 2023-06-05 15:13
 * @description: 22
 */
public class Test {
    public static boolean fun(String str) {
        //边界判断
        if (str.length() <= 1){
            return true;
        }

        // 1、最多删除一个字符，第一步判断原本字符串是否就是回文字符串
        checkStr(str);

        boolean flag = false;
        //2、删除一个字符场景
        for (int i = 0; i < str.length(); i++) {
            String a = delectChar(str, i);
            flag = checkStr(a);
        }
        return flag;
    }

    /**
     * 判断字符串是否是回文字符串
     *
     * @return
     */
    public static boolean checkStr(String str) {
        int left = 0;
        int right = str.length() - 1;
        boolean result = true;
        while (left < right) {
            char c1 = str.charAt(left);
            char c2 = str.charAt(right);

            if (c1 != c2){
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }

    /**
     * 删除字符
     *
     * @param str
     * @param index
     * @return
     */
    public static String delectChar(String str, int index) {
        String a = str.substring(0, index) + str.substring(index + 1);
        return a;
    }

    public static void main(String[] args) {
//        String str = "abc";
//        System.out.println(delectChar(str, 0));

        String str = "abc";
        System.out.println(fun(str));
    }
}
