package com.example.demo.hw;

import java.util.Scanner;

/**
 * @author: sunzhinan
 * @create: 2022-04-13 22:10
 * @description: 牛客网华为机试第一题
 */
public class Test019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        String s = str.substring(str.lastIndexOf(" ") + 1);

        System.out.println(s.length());

    }
}
