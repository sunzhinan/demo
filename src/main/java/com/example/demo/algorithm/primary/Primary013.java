package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-14 22:49
 * @description: leetcode_初级算法题
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 */
public class Primary013 {
    public static int reverse(int x){
        String str = String.valueOf(x);
        char[] c = str.toCharArray();
        reverseString(c);
        str = new String(c);

        if (str.endsWith("-")) {
            str= "-" + str.substring(0,str.length()-1);
        };
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }

    public static void reverseString(char[] s){
        int left = 0;
        int right = s.length-1;

        while (left < right){
            char a = s[left];
            s[left] = s[right];
            s[right] = a;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(reverse(x));
    }
}
