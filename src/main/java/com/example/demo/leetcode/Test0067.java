package com.example.demo.leetcode;

/**
 * @author: sunzhinan
 * @create: 2022-04-12 23:56
 * @description: leetcode第67题
 */
public class Test0067 {
    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        char[] temp;
        if (charsA.length > charsB.length) {
            temp = create(charsB,charsA);
            return fun(charsA, temp);
        } else {
            temp = create(charsA,charsB);
            return fun(charsB, temp);
        }

    }

    private static char[] create(char[] charsA, char[] charsB){
        char[] temp = new char[charsB.length];
        int k = charsB.length - charsA.length;
        for (int i = 0; i < charsA.length; i++) {
            temp[i + k] = charsA[i];
        }
        for (int i = 0; i < k; i++) {
            temp[i] = '0';
        }
        return temp;
    }

    private static String fun(char[] a, char[] b) {
        StringBuilder stringBuilder = new StringBuilder("");
        int n = 0;
        for (int i = 1; i <= a.length; i++) {
            int k = (a[a.length - i]-'0') + (b[b.length - i]-'0') + n;
            if(k == 0){
                stringBuilder.append("0");
            }else if(k == 1){
                stringBuilder.append("1");
                n = 0;
            }else if(k == 2){
                stringBuilder.append("0");
                n = 1;
            }else if(k == 3){
                stringBuilder.append("1");
                n = 1;
            }
        }

        if (n == 1) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10";
        String b = "01";

        System.out.println(addBinary(a, b));
    }
}
