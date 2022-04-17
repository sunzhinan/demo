package com.example.demo.leetcode;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 21:06
 * @description: leetcode 第101题
 */
public class LeetCode0101 {

    public boolean isSameTree(LeetCode0100.TreeNode node) {
        return fun(node,node);
    }

    private static boolean fun(LeetCode0100.TreeNode node1,LeetCode0100.TreeNode node2){
        if (node1 == null ^ node2 == null){
            return  false;
        }
        if (node1 == null && node2 == null){
            return true;
        }

        return node1.val == node2.val && fun(node1.left,node2.right) && fun(node1.right,node2.left);
    }
}
