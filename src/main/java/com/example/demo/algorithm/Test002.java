package com.example.demo.algorithm;

/**
 * @author: sunzhinan
 * @create: 2021-10-29 22:29
 * @description: 打印int类型数字的32位字符串
 */
public class Test002 {

    /**
     *  随机答应一个int类型数字的二进制
     * @param args
     */
    public static void main(String[] args) {
        int i = -1;
        int a = -1;

        System.out.println(function(i));
        System.out.println(function((~a + 1)));

        System.out.println(function(Integer.MIN_VALUE));

    }

    private static String function(int i){
        StringBuilder builder = new StringBuilder("");
        for(int j = 31 ;j >= 0;j--){
            builder.append((i & ( 1 << j))== 0 ? "0":"1");
        }
        return builder.toString();
    }
}
