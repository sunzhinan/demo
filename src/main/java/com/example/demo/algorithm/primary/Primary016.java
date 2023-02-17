package com.example.demo.algorithm.primary;



/**
 * @author: sunzhinan
 * @create: 2023-02-17 23:10
 * @description: leetcode_初级算法题
 */
public class Primary016 {

    public static boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuffer newSb = new StringBuffer(sb.reverse());
        return newSb.reverse().toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
