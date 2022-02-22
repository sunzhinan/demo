package com.example.demo.hw;

import java.util.Scanner;

/**
 * 【转骰子】骰子是一个立方体，每个面一个数字，初始为左1，右2，前3(观察者方向)，后4，上5，下6，用123456表示这个状态，放置在平面上，可以向左翻转(用L表示向左翻转1次)，
 * 可以向右翻转(用R表示向右翻转1次)，可以向前翻转(用F表示向前翻转1次)，可以向后翻转(用B表示向后翻转1次)，可以逆时针旋转(用A表示逆时针旋转90度)，可以顺时针旋转(用C表示顺时针旋转90度)，
 * 现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。骰子的初始状态和初始状态转动后的状态如图所示
 *
 * 输入
 * L R
 * 输出
 * 123456
 */
public class Test008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        scanner.close();

        char[] results = {'1','2','3','4','5','6'};
        String[] strs = str.split(" ");
        for (int i = 0 ;i<strs.length;i++){
            String s = strs[i];
            if (s.equals("L")){
                char a = results[0];
                char b = results[1];

                results[0] = results[4];
                results[1] = results[5];
                results[4] = b;
                results[5] = a;
            }else if (s.equals("R")){
                char a = results[0];
                char b = results[1];

                results[0] = results[5];
                results[1] = results[4];
                results[4] = a;
                results[5] = b;
            }else if (s.equals("F")){
                char a = results[2];
                char b = results[3];

                results[2] = results[4];
                results[3] = results[5];
                results[4] = b;
                results[5] = a;

            }else if (s.equals("B")){
                char a = results[2];
                char b = results[3];

                results[2] = results[5];
                results[3] = results[4];
                results[4] = a;
                results[5] = b;

            }else if (s.equals("A")){
                char a = results[0];
                char b = results[1];

                results[0] = results[3];
                results[1] = results[2];
                results[2] = a;
                results[3] = b;
            }else if (s.equals("C")){
                char a = results[0];
                char b = results[1];

                results[0] = results[2];
                results[1] = results[3];
                results[2] = b;
                results[3] = a;
            }

            // 输出结果
            System.out.println(new String(results));

        }

    }
}
