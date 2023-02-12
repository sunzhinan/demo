package com.example.demo.algorithm.test;

import java.util.Comparator;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 15:50
 * @description: 比较器
 */
public class MyComparator implements Comparator<DemoInfo> {

    /**
     * 返回-1：o1在前
     * 返回1：o2在前
     * 返回0；o1，o2谁前谁后不分
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(DemoInfo o1, DemoInfo o2) {
        if (o1.getAge() < o2.getAge()){
            return -1;
        }else if(o1.getAge() > o2.getAge()){
            return 1;
        }
        return 0;
    }
}
