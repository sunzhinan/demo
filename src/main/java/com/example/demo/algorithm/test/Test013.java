package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 20:13
 * @description: 深度优先遍历二叉树
 */
public class Test013 {
    private static MyTree myTree;

    private static void initTree(){
        myTree = new MyTree(1);
        myTree.leftNode = new MyTree(2);
        myTree.rightNode = new MyTree(3);
        myTree.leftNode.leftNode = new MyTree(4);
        myTree.leftNode.rightNode = new MyTree(5);
        myTree.rightNode.leftNode = new MyTree(6);
        /**
         *              1
         *      2               3
         *  4       5       6
         */
    }

    /**
     * 前序遍历
     * @param tree
     */
    public static void fun1(MyTree tree){
        if(tree == null){
            return;
        }
        System.out.print(tree.value + " ");
        fun1(tree.leftNode);
        fun1(tree.rightNode);
    }

    /**
     * 中序遍历
     * @param tree
     */
    public static void fun2(MyTree tree){
        if(tree == null){
            return;
        }
        fun2(tree.leftNode);
        System.out.print(tree.value + " ");
        fun2(tree.rightNode);
    }

    /**
     * 后序遍历
     * @param tree
     */
    public static void fun3(MyTree tree){
        if(tree == null){
            return;
        }
        fun3(tree.leftNode);
        fun3(tree.rightNode);
        System.out.print(tree.value + " ");
    }

    public static void main(String[] args) {
        initTree();
        System.out.println("前序遍历：");
        fun1(myTree);
        System.out.println();
        System.out.println("中序遍历：");
        fun2(myTree);
        System.out.println();
        System.out.println("后序遍历：");
        fun3(myTree);
    }
}
/**
 * 结果：
 * 前序遍历：
 * 1 2 4 5 3 6
 * 中序遍历：
 * 4 2 5 1 6 3
 * 后序遍历：
 * 4 5 2 6 3 1
 */
