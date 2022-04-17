package com.example.demo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 17:30
 * @description: leetcode 23题
 */
public class LeetCode0023 {

    private static class ListNode {
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

    private static class ListNodeComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    private static ListNode fun(ListNode[] lists){
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
                priorityQueue.add(lists[i]);
            }
        }

        if (priorityQueue.isEmpty()){
            return null;
        }

        // 头节点就能直接确认
        ListNode head = priorityQueue.poll();

        // 确认了头节点后，将头节点所在的链表下一个值放入队列
        ListNode temp = head;
        if(temp.next != null){
            priorityQueue.add(temp.next);
        }

        //弹出一个，将下一个node放入，并且将head的next指定为每次弹出的值
        while (!priorityQueue.isEmpty()){
            ListNode cur = priorityQueue.poll();
            temp.next = cur;
            temp = cur;
            if(cur.next != null){
                priorityQueue.add(cur.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listOne = new ListNode(1);
        listOne.next = new ListNode(4);
        listOne.next.next = new ListNode(5);

        ListNode listTwo = new ListNode(1);
        listTwo.next = new ListNode(3);
        listTwo.next.next = new ListNode(4);

        ListNode listThree = new ListNode(2);
        listThree.next = new ListNode(6);


        ListNode[] lists = {listOne,listTwo,listThree};

        ListNode newNode = fun(lists);

        while (newNode.next != null){
            System.out.print( newNode.val + " ");
            newNode = newNode.next;
        }

    }
}
