package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-14 23:40
 * @description: leetcode_初级算法题
 *
 * 给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 *
 */
public class Primary014 {
    public static int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(String.valueOf(s.charAt(i))) == s.lastIndexOf(String.valueOf(s.charAt(i)))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
