package com.example.demo.hw;

/**
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32位正整数， 请对其进行因数分解，找出是哪两个素数的乘积。
 * 素数又称质数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。
 * 输入  15
 * 输出  3 5
 *
 * 输入  27
 * 输出  -1 -1
 */
public class Test003 {
    private static String fun(int num){
        // 1 不是质数，因此从2开始计算
        for (int a = 2; a < num; a++) {
            for (int b = 2; b < num; b++) {
                if(a*b==num && isPrime(a) && isPrime(b)){
                    return a + " " + b;
                }
            }
        }

        return "-1 -1";
    }

    /**
     * 判断是否为质数
     * @param a
     * @return
     */
    private static boolean isPrime(int a){
        //这里一定要注意i*i是小于等于a
        for(int i = 2; i*i <= a; i++){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(fun(27));

        System.out.println(fun(15));

        System.out.println(fun(21));
    }
}
