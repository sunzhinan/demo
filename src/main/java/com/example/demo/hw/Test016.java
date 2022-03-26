package com.example.demo.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 可信二期22题
 */
public class Test016 {

    private static int fun(){
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        scanner.close();

        String str = "7 5 9 4 2 6 8 3 5 4 3 9";
//        String str = "1 2 3 7 1 5 9 3 2 1";
        String[] s = str.split(" ");
        int sum = -1;

        int a[] = Arrays.asList(s).stream().mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < a.length/2; i++) {
            int next = i;
            int k = 1;
            while (next < a.length){
                if(next == a.length-1){
                    if(sum == -1){
                        sum = k;
                    }else
                    {
                        sum = sum < k ? sum : k;
                    }
                    break;
                }
                next = a[next] + next;
                k++;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}
