package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sunzhinan
 * @create: 2023-05-23 20:44
 * @description: leetcode第三题
 */
public class LeetCode0003 {
    public static void main(String[] args) {
        String str = "abbbcacbb";
        System.out.println(fun(str));
    }

    public static int fun(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < str.length()) {
            char c = str.charAt(right);
            if (map.containsKey(c)) {
                /**
                 * 为啥这里用Math.max方法来移动left？
                 */
                left = Math.max(left,map.get(c) +1 );
            }
            map.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
