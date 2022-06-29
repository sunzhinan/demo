package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2022-04-25 23:05
 * @description: 判断是否是平衡二叉树
 */
public class Test014 {
    /**
     * 平衡二叉树的定义就是，树上所有的子节点的左树和右树的高度相差小于等于1
     *
     * 【重点】那么判读一棵树是否是平衡二叉树，我们可以拆分为，
     * 这棵树上某个节点的左子树是一个平衡二叉树，
     * 右子树是一个平衡二叉树，且左右子树的高度相差小于等于1
     */

    /**
     * 每个树节点的信息
     */
    public static class TreeInfo{
        int height;
        /*
        是否是平衡二叉树
         */
        boolean isBalanced;
        public TreeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static TreeInfo fun(TreeNode node){
        if (node == null){
            return new TreeInfo(0,true);
        }

        TreeInfo leftTreeInfo = fun(node.left);
        TreeInfo rightTreeInfo = fun(node.right);

        // 当前节点的高度
        int height = Math.max(leftTreeInfo.height,rightTreeInfo.height) + 1;
        boolean isbalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced && Math.abs(leftTreeInfo.height - rightTreeInfo.height) < 2;

        return new TreeInfo(height,isbalanced);
    }
}
