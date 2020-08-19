package com.example.demo.basis.test;


import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /* -XX:+UseParallelOldGC和-XX:+UseParallelGC结果一样，因为MXBean名字一样，但是实际使用的不一样 */
        List<java.lang.management.GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }
    }
}
