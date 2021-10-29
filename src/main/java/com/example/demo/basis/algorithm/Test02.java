package com.example.demo.basis.algorithm;

/**
 * @author: sunzhinan
 * @create: 2021-10-29 22:29
 * @description: 打印int类型数字的32位字符串
 */
public class Test02 {

    /**
     *  随机答应一个int类型数字的二进制
     * @param args
     */
    public static void main(String[] args) {
        int i = 8;
        // 方法一：
        System.out.println(function1(i));

        // 方法二：
        System.out.println(function2(i));

    }

    private static String function1(int i){
        StringBuilder builder = new StringBuilder("");
        while (i!=1)
        {
            builder.append(i%2 == 0 ? "0":"1");
            i = i/2;
        }
        builder.append("1");
        int length = builder.toString().length();
        for (int j = 0; j < 32 - length; j++) {
            builder.append("0");
        }
        return builder.reverse().toString();
    }

    private static String function2(int i){
        StringBuilder builder = new StringBuilder("");
        for(int j = 31 ;j >= 0;j--){
            builder.append((i & ( 1 << j))== 0 ? "0":"1");
        }
        return builder.toString();
    }
}
