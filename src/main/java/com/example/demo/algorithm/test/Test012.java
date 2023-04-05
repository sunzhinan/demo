package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-15 23:40
 * @description: 反转链表
 */
public class Test012 {
    private static Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            // 转方向
            head.next = pre;
            // 记录位置
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        while (node != null){
            System.out.print(node.value + " --> ");
            node = node.next;
        }
    }
}
