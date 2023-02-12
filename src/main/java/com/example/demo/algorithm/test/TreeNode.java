package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-25 23:12
 * @description: 二叉树类
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
