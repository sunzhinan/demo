package com.example.demo.leetcode;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 20:58
 * @description: Leetcode第100题
 */
public class LeetCode0100 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        /**
         * p和q，一个为空一个不为空
         */
        if(p == null ^ q == null){
            return false;
        }

        if(p == null && q == null){
            return true;
        }

        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.left);
    }

}
