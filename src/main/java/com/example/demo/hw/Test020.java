package com.example.demo.hw;

import java.util.Scanner;

/**
 * @author: sunzhinan
 * @create: 2022-04-13 22:19
 * @description: 牛客网华为机试第二题
 */
public class Test020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String str1 = scanner.nextLine();
//        String str2 = scanner.nextLine();

        String str1 = "ASFaasd sef";
        String str2 = "A";
        char c = str2.charAt(0);
        scanner.close();

        String s = str1.toLowerCase();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)){
                k++;
            }
        }
        System.out.println(k);
    }
}
