package com.example.demo.algorithm;

import java.util.LinkedList;

/**
 * @author: sunzhinan
 * @create: 2022-04-11 23:10
 * @description: 单链表示例
 */
public class Test011 {

    public static void main(String[] args) {
        DemoInfo info1 = new DemoInfo("xiaoming", "man", 23);
        DemoInfo info2 = new DemoInfo("xiaoli", "man", 22);
        DemoInfo info3 = new DemoInfo("xiaosong", "woman", 25);

        MyLinkDemo<DemoInfo> myLinkDemo1 = new MyLinkDemo<>();
        MyLinkDemo<DemoInfo> myLinkDemo2 = new MyLinkDemo<>();
        MyLinkDemo<DemoInfo> myLinkDemo3 = new MyLinkDemo<>();
        myLinkDemo1.data = info1;
        myLinkDemo2.data = info2;
        myLinkDemo3.data = info3;
        myLinkDemo1.next = myLinkDemo2;
        myLinkDemo2.next = myLinkDemo3;
    }
}
