package com.example.demo.leetcode;

import java.util.HashMap;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 23:56
 * @description: leetcode第105题
 */
public class LeetCode0105 {

    public static class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return fun(preorder,0,preorder.length-1,inorder,0,inorder.length-1, map);
    }

    private static TreeNode fun(int[] pre, int l1, int r1 ,int[] in, int l2, int r2,HashMap map){
        if(l1 > r1){
            return null;
        }
        TreeNode head = new TreeNode(pre[l1]);
        if (l1 == r1){
            return head;
        }
        int headIndex = (int) map.get(pre[l1]);

        head.left = fun(pre,l1+1,l1+headIndex-l2,in,l2,headIndex-1,map);
        head.right = fun(pre,l1+headIndex-l2 +1,r1,in,headIndex +1,r2,map);
        return head;
    }
}
