package com.example.demo.hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 幼儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友是否同班，请你帮忙把同班的小朋友找出来。
 * 小朋友的编号为整数，与前一位小朋友同班用Y表示，不同班用N表示。
 *
 * 输入为空格分开的小朋友编号和是否同班标志。
 * 比如：6/N 2/Y 3/N 4/Y，表示共4位小朋友，2和6同班，3和2不同班，4和3同班。
 * 其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
 * 不考虑输入格式错误问题。
 *
 * 输入：
 * 1/N 2/Y 3/N 4/Y
 * 输出：
 * 1 2
 * 3 4
 */
public class Test006 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        scanner.close();

        String str = "1/N 2/Y 3/N 4/Y 5/Y 6/N 7/Y 8/Y";

        String[] strArray = str.split(" ");

        String a = "";
        String b = "";

        ArrayList<Integer> oneList = new ArrayList<Integer>();
        ArrayList<Integer> twoList = new ArrayList<Integer>();
        String lastList = "";
        for (int i = 0;i<strArray.length;i++){
            int index = strArray[i].indexOf("/");
            a = strArray[i].substring(0,index);
            b = strArray[i].substring(index + 1);
            int num = Integer.parseInt(a);

            if(i == 0){
                oneList.add(num);
                lastList = "oneList";
                continue;
            }

            if(b.equals("Y")){
                if(lastList.equals("oneList")){
                    oneList.add(num);
                    lastList = "oneList";
                }else{
                    twoList.add(num);
                    lastList = "twoList";
                }
            }else{
                if(lastList.equals("oneList")){
                    twoList.add(num);
                    lastList = "twoList";
                }else{
                    oneList.add(num);
                    lastList = "oneList";
                }
            }

        }


        // 输出
        System.out.println(oneList.toString());
        System.out.println(twoList.toString());


    }
}
