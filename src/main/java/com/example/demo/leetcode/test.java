package com.example.demo.leetcode;

import java.util.HashMap;

/**
 * @author: sunzhinan
 * @create: 2024-03-23 13:37
 * @description:
 */
public class test {

    public static void main(String[] args) {
        String s = "efsefweewwwew";
        HashMap<Character, Integer> map = new HashMap<>(8);
        int lenght = s.length();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < lenght){
            char c = s.charAt(right);
            if (map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,right);
            result = Math.max(result,right-left+1);
            right++;
        }
        System.out.println(result);
    }
}
