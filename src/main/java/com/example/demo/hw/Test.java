package com.example.demo.hw;

import java.util.Arrays;

/**
 * @author: sunzhinan
 * @create: 2022-04-10 23:31
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        int[] arrays = {2,3,2,3,4,2,4,55,64,3,43,454};
//        int[] arrays = {1,2,2};
        int length = arrays.length;

        Arrays.sort(arrays);

        for (int i = 0; i < length - 1; i++) {
            int ans = arrays[i] ^ arrays[i+1];
            if(ans != 0){
                System.out.println(arrays[i]);
                ans = 0;
                if(i == length -2){
                    System.out.println(arrays[i+1]);
                }
            }else if ( i == length -2){
                System.out.println(arrays[i]);
            }

        }


    }
}
