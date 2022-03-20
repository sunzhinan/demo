package com.example.demo.hw;

/**
 *已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
 *
 * x#y = 2x+3y+4
 * x$y = 3*x+y+2
 * 其中x、y是无符号整数
 * 地球人公式按C语言规则计算
 * 火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算 现有一段火星人的字符串报文，请你来翻译并计算结果。
 */
public class Test011 {

    private static int sum = 0;

    public static int sum1(int x, int y){
        return 2*x+3*y+4;
    }

    public static int sum2(int x, int y){
        return 3*x+y+2;
    }

    public static int fun(String str){
        int index = str.indexOf("$");
        if(index != -1){
            String s1 = str.substring(0,index);
            String s2 = str.substring(index+1);

            String s3 = s1.substring(s1.lastIndexOf("#") +1);
            String s4 = s2.substring(0,s2.indexOf("#"));

            String s5 = s1.substring(0,s1.lastIndexOf("#")+1);
            String s6 = s2.substring(s2.indexOf("#"));


            int a = Integer.parseInt(s3);
            int b = Integer.parseInt(s4);
            sum= sum2(a,b);
            fun(s5 + sum + s6);
        }else {
            int index2 = str.indexOf("#");
            if(index2 != -1){
                String s1 = str.substring(0,index2);
                String s2 = str.substring(index2+1);
                int a = Integer.parseInt(s1);
                if(s2.indexOf("#") != -1){
                    String s3 = s2.substring(0,s2.indexOf("#"));
                    String s4 = s2.substring(s2.indexOf("#"));
                    int b = Integer.parseInt(s3);
                    sum = sum1(a,b);
                    fun(sum+s4);
                }else
                {
                    int b = Integer.parseInt(s2);
                    sum = sum1(a,b);
                    return sum;
                }
            }else
            {
                return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fun("7#6$5#12"));
    }
}
