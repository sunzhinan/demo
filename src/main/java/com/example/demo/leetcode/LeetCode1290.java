package com.example.demo.leetcode;

/**
 * @author: sunzhinan
 * @create: 2022-04-15 23:08
 * @description:
 */
public class LeetCode1290 {

    public static int getDecimalValue(ListNode head) {
        // 1、反转链表
        ListNode node = reverse(head);
        int k = 0;
        int num = 0;
        while (node != null){
            if (node.val == 1){
                /**
                 * 00000000 ｜ 00000001 = 00000001
                 * 00000001 ｜ 00000100 = 00000101
                 * 00000101 ｜ 00001000 = 00001101
                 */
                k = k | (1 << num);
            }
            num++;
            node = node.next;
        }

        return k;
    }

    public static int getDecimalValue2(ListNode head) {
        int k = 0;
        while (head != null){
            k = k << 1;
            k = k | head.val;
            head = head.next;
        }
        return k;
    }

    /**
     * 反转链表
     * @param node
     * @return
     */
    private static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next = null;

        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(0);
        node1.next.next = new ListNode(0);
        node1.next.next.next = new ListNode(1);

//        System.out.println(getDecimalValue(node1));

        System.out.println(getDecimalValue2(node1));

    }
}

