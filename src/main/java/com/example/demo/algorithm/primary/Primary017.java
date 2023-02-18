package com.example.demo.algorithm.primary;

/**
 * @author: sunzhinan
 * @create: 2023-02-18 11:04
 * @description: leetcode_初级算法题
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Primary017 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }

        // 先找出长度最短
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min,strs[i].length());
        }

        if (min == 0){
            return "";
        }

        String str = strs[0];
        String result = "";
        for (int i = 1; i <= min ; i++) {
            result = str.substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(result)){
                    return result.substring(0,result.length()-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"",""};
        String[] strs = {"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
