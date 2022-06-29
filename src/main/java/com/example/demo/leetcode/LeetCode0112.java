package com.example.demo.leetcode;

import com.example.demo.algorithm.TreeNode;

/**
 * @author: sunzhinan
 * @create: 2022-04-27 00:06
 * @description: leetcode第112题
 */
public class LeetCode0112 {
    private static boolean isSum = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        isSum = false;
        process(root,0,targetSum);
        return isSum;
    }

    public static void process(TreeNode node, int cur, int sum){
        // 叶子节点
        if(node.left == null && node.right == null){
            if((cur + node.val) == sum){
                isSum = true;
                return;
            }
        }
        cur += node.val;
        if (node.left != null){
            process(node.left, cur, sum);
        }
        if (node.right != null){
            process(node.right, cur, sum);
        }

    }

}
