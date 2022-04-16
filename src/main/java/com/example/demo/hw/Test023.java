package com.example.demo.hw;

import java.util.Scanner;

/**
 * @author: sunzhinan
 * @create: 2022-04-17 00:24
 * @description: 牛客网华为笔试第五题
 */
public class Test023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        System.out.println(Integer.parseInt(str.substring(2),16));


    }
}
