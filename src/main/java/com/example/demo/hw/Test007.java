package com.example.demo.hw;

import java.util.*;

/**
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。
 *
 * 一个选手可以有多个射击成绩的分数，且次序不固定。
 * 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
 * 如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
 *
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=100）。
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID（0<=ID<=99）。
 * 输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩（0<=成绩<=100）。
 *
 * 输入：
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 *
 * 输出：
 * 5,3,7,4
 */
public class Test007 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        String oneStr = scanner.nextLine();
//        String twoStr = scanner.nextLine();
//        String threeStr = scanner.nextLine();
        String oneStr = "13";
        String twoStr = "3,3,7,4,4,4,4,7,7,3,5,5,5";
        String threeStr = "53,80,68,24,39,76,66,16,100,55,53,80,55";

        // 组装参数
        int total = Integer.valueOf(oneStr);
        int[] number = Arrays.stream(twoStr.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] score = Arrays.stream(threeStr.split(",")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(8);
        HashMap<Integer, Integer> finalMap = new HashMap<>(8);
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < total; i++) {
            numSet.add(number[i]);
            if(map.get(number[i]) != null && map.get(number[i]).size() != 0){
                ArrayList<Integer> list = map.get(number[i]);
                list.add(score[i]);
                Collections.sort(list);
                map.put(number[i],list);

                if(list.size() >= 3){
                    finalMap.put(number[i],list.get(0) + list.get(1) + list.get(2));
                }
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score[i]);
                Collections.sort(list);
                map.put(number[i],list);
            }
        }

        Set<Integer> scoreSet = new HashSet<>();
        for (Integer i: numSet) {
            scoreSet.add(finalMap.get(i));
        }

        ArrayList<Integer> scoreList = new ArrayList<>();
        for (Integer i: scoreSet) {
            scoreList.add(i);
        }

        Collections.sort(scoreList,Collections.reverseOrder());
        ArrayList<Integer> numList = new ArrayList<>();
        for(Integer i: scoreList){
            ArrayList<Integer> tempList = new ArrayList<>();
            int k = 0;
            for(Integer j: numSet){
                if(finalMap.get(j).equals(i)){
                    tempList.add(j);
                    k++;
                }

                if(k != 1){
                    Collections.sort(tempList,Collections.reverseOrder());
                }
            }
            numList.addAll(tempList);
        }


        // 输出
        System.out.println(numList.toString());


    }
}
