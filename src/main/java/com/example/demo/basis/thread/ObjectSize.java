package com.example.demo.basis.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class ObjectSize {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        int B = ai.incrementAndGet();
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        StringBuilder sb = new StringBuilder();
        sb.append("111");

        StringBuffer str = new StringBuffer();
        str.append("aaa");

        synchronized(o){
            System.out.println("---------------------------------------------------------");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
