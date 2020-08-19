package com.example.demo.basis.thread.concurrent;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: sunzhinan
 * @create: 2020-05-25 23:51
 * @description: 同步集合
 */
public class TestConcurrentMap {

    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","aaa");
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();


    }
}
