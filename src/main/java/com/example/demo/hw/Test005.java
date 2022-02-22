package com.example.demo.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 *
 */
public class Test005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        String n = scanner.nextLine();
//        scanner.close();
//        String m = "3 5";
//        String n = "8 4 3 2 10";

        String[] mArray = m.split(" ");
        int a = Integer.parseInt(mArray[0]);
        int b = Integer.parseInt(mArray[1]);

        String[] nArray = n.split(" ");
        // 排序
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nArray).map(Integer::parseInt).sorted().collect(Collectors.toList());

        // b % a取余，获得那一条生产线耗时最长
        int x = b % a;
        int y = a -1;
        if(x != 0){
            y = x - 1;
        }

        int sum = 0;
        for (int i = y ;i < list.size();i+=a){
            sum = sum + list.get(i);
        }

        // 返回sum
        System.out.println(sum);
    }
}
