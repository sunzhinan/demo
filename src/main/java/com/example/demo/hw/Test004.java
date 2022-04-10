package com.example.demo.hw;

/**
 * 【字符串分割】给定非空字符在s，将该字符串分割成一些子串，使每个子串的ASCIIA码值的和均为水仙花数。
 *
 * 补充：水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身。
 *
 *
 * 输入  abc
 * 输出  0
 */
public class Test004 {

    private static int length ;

    private static String subString;

    private static int k = 0;

    private static int num = 0;

    private static boolean flag = false;

    private static int fun(String str){
        // 遍历，相加，得到的数值调用isNum方法判断是否是水仙花数即可

        if (str.length() < 2){
            return 0;
        }

        subString = str;
        for (int i = 2; i < subString.length(); i++) {
            num = 0;
            sub(subString.substring(0,i),0,1);

            if (flag){
                k++;
            }
        }

        if (k  > 1){
            // 分割不成功
            return -1;
        }else if( k == 1){
            return num;
        }
        return 0;
    }

    private static void sub(String str, int start,int end){
        if(end > length || start > length){
            return;
        }
        String s = str.substring(start , end);
        char[] chars = s.toCharArray();

        int ans = 0;
        for (int i = 0 ; i < chars.length;i++){
            ans = ans + chars[i];
        }
        // 判断是否是水仙花数
        if (isNum(ans)){
            flag = true;
            num++;
            sub(subString,end,end+1);

        }else{
            flag = false;
            sub(subString,start,end+1);
        }

    }

    /**
     * 判断是否是水仙花数
     * 371=3^3+7^3+1^3
     * @param num
     */
    private static boolean isNum(int num){
        if(num < 100 || num > 999){
            return false;
        }

        int a = num%10;
        int b = num/10%10;
        int c = num/100%10;
        if((a*a*a + b*b*b + c*c*c) == num){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 校验判断是否为水仙花数方法是否正确
        System.out.println(isNum(371));
        System.out.println(isNum(370));
        System.out.println(isNum(375));

        System.out.println("-------------");

        System.out.println(fun("ZZZeZZZe"));
    }
}
