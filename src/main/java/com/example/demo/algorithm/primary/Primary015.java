package com.example.demo.algorithm.primary;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2023-02-16 21:58
 * @description: leetcode_初级算法题
 */
public class Primary015 {

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int index = 0;
        boolean flag = true;
        while (index < a.length){
            if(a[index] != b[index]){
                flag = false;
                break;
            }
            index++;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
//        String s = "cat";
//        String t = "rat";
        System.out.println(isAnagram(s,t));
    }
}
