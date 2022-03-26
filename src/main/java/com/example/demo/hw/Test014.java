package com.example.demo.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 可信二期20题
 */
public class Test014 {

    private static String fun(double a[][],int b[],double c[],String s[]){
        boolean flag = true;
        boolean result = true;
        int length = c.length;

        int k[] = new int[c.length];
        for (int i = 0; i < a.length; i++) {
            double sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum = sum + a[i][j] * b[j];
            }

            if(s[i].equals(">")){
                flag = sum > c[i];
            }else if(s[i].equals(">=")){
                flag = sum >= c[i];
            }else if(s[i].equals("<")){
                flag = sum < c[i];
            }else if(s[i].equals("<=")){
                flag = sum <= c[i];
            }else{
                flag = sum == c[i];
            }
            k[i] = (int)(sum - c[i]);
            if(!flag){
                result = false;
            }

        }

        Arrays.sort(k);

        return result + " " + k[length-1];
    }

    public static void main(String[] args) {
//        double a[][] = {
//                {2.3,3,5.6,7,6},
//                {11,3,8.6,25,1},
//                {0.3,9,5.3,66,7.8}
//        };
//        int b[] ={1,3,2,7,5};
//        double c[] = {340,670,80.6};
//        String s[] = {"<=","<=","<="};

        double a[][] = {
                {2.36,3,6,7.1,6},
                {1,30,8.6,2.5,21},
                {0.3,69,5.3,6.6,7.8}
        };
        int b[] ={1,13,2,17,5};
        double c[] = {340,67,300.6};
        String s[] = {"<=",">=","<="};
        System.out.println(fun(a,b,c,s));
    }
}
