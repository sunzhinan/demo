package com.example.demo.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: sunzhinan
 * @create: 2022-04-13 22:31
 * @description: 牛客网华为机试第三题
 */
public class Test021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arrays = new int[length];
        int k = 0;
        while (k < length){
            arrays[k] = scanner.nextInt();
            k++;
        }
        scanner.close();

        Arrays.sort(arrays);

        for (int i = 0; i < length - 1; i++) {
            int ans = arrays[i] ^ arrays[i+1];
            if(ans != 0){
                System.out.println(arrays[i]);
                ans = 0;

                if (i == length -2){
                    System.out.println(arrays[i+1]);
                }
            }else if ( i == length -2){
                System.out.println(arrays[i]);
            }

        }

    }
}
