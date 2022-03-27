package com.example.demo.hw;

import java.util.Scanner;

/**
 * 可信二期25题
 */
public class Test018 {
    private static boolean flag = true;

    private static String s1 = "";

    private static int fun(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        // 验证
//        String str = "(({[]}))][";
//        String str = "(({[]}))";
//        String str = "(({[]}))(({[({})]}))";
        int length = str.length();

        // 如果不是偶数，即一定不是有效字符串
        if(length%2 !=0 ){
            return 0;
        }

        // 开始替换
        replace(str);

        // 如果最终替换了还有长度，说明不符合
        if (s1.length() > 0){
            return 0;
        }

        String s = str.replace("[","(").replace("]",")").replace("{","(").replace("}",")");

        String s1 = s.replace(")(" , "),(");

        String[] strings = s1.split(",");

        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            if(max < strings[i].length() / 2){
                max = strings[i].length() / 2;
            }
        }

        return max;
    }

    private static void replace(String str){
        String s = str.replace("[]","").replace("{}","").replace("()","");
        if(s.length() == 0){
            flag = false;
        }else if (s.length() > 0 && s.length() == str.length())
        {
            s1 = s;
            flag = false;
        }else
        {
            replace(s);
        }

        if (!flag){
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}
