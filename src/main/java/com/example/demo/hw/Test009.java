package com.example.demo.hw;

import java.util.Scanner;

/**
 * 给定一个url前缀和url后缀,通过,分割 需要将其连接为一个完整的url
 * 如果前缀结尾和后缀开头都没有/，需要自动补上/连接符
 * 如果前缀结尾和后缀开头都为/，需要自动去重
 * 约束：不用考虑前后缀URL不合法情况
 */
public class Test009 {
    public static String fun(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        String[] strs = str.split(",");

        String a = strs[0].replaceAll("/" , "");
        String b = strs[1].replaceAll("/" , "");

        return "/" + a + "/" + b;
    }

    public static void main(String[] args) {

        System.out.println(fun());
    }
}
