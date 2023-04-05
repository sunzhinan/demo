package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-19 23:56
 * @description: leetcode_初级算法题
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 */
public class Primary018 {

    public static int strStr(String haystack, String needle) {
        String s = haystack.replaceFirst(needle," ");

        return s.indexOf(" ");
    }

    public static void main(String[] args) {
        String haystack = "sabutad", needle = "sad";
        System.out.println(strStr(haystack,needle));
    }
}
