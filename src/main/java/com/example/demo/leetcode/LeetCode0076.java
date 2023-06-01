package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sunzhinan
 * @create: 2023-05-23 21:48
 * @description: leetcode第76题
 */
public class LeetCode0076 {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(str,t));
    }

    public static String minWindow(String s,String t){
        Map<Character,Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i) , mapT.getOrDefault(t.charAt(i),0) + 1);
        }
        int left = 0 ;
        int right = 0;
        int min = s.length() + 1;
        int tLength = t.length();
        int start = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if(mapT.containsKey(c)){
                mapT.put(c,mapT.get(c)-1);
                tLength--;
            }

            if (tLength == 0){
                while (left < right || (mapT.containsKey(s.charAt(left)) && mapT.get(s.charAt(left)) < 0)){
                    if(mapT.containsKey(s.charAt(left))){
                        mapT.put(s.charAt(left),mapT.get(s.charAt(left)) +1);
                    }
                    left++;
                }
                if (right - left + 1 < min){
                    min = right -left +1;
                    start = left;
                }
                if(mapT.containsKey(s.charAt(left))){
                    mapT.put(s.charAt(left),mapT.get(s.charAt(left)) +1);
                }

                left++;
            }
            right++;
        }
        System.out.println(min);
        System.out.println(start);
        return min < tLength ? s.substring(start,start+min) : "";
    }
}