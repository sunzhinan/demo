package com.example.demo.hw;

/**
 * 可信二期21题
 */
public class Test015 {
    private static int length;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static  boolean flag = true;
//    private static char c[][] = {
//            {'A','A','C','C','F'},
//            {'K','C','D','E','D'},
//            {'A','B','E','S','S'},
//            {'C','F','E','C','A'},
//            {'C','F','E','C','A'}
//
//    };

    private static char c[][] = {
            {'A','C','C','F'},
            {'C','D','E','D'},
            {'B','E','S','S'},
            {'F','E','C','A'}

    };
    private static int strLength;
    private static char strs[] ;

    private static String fun(){

        String s = "ACCESS";

        strs = s.toCharArray();

        length = c.length;
        strLength = s.length();

        // 循环比较
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                // 当二维数组中某一位置和字符串第一个字母匹配上，则开始递归比较其相邻字符是否匹配
                if(c[i][j] == strs[0]){
                    // 递归标识一开始设为true
                    flag = true;
                    // 拼接上第一次匹配到下标
                    stringBuilder.append(i + "," + j + ",");

                    // 递归比较
                    check(i,j,0);

                    // 如果发现stringbuilder长度大于0，则说明匹配上了，那就直接返回
                    if (stringBuilder.length() > 0){
                        return stringBuilder.toString();
                    }
                }
            }
        }

        return null;
    }

    /**
     * 递归比较方法
     * @param i 二维数组x轴下标
     * @param j 二维数组y轴下标
     * @param k 记录字符串下标
     */
    private static void check(int i,int j,int k){

        // 递归退出标识
        if (!flag){
            return;
        }

        if (k+1 == strLength){
            flag = false;
            return;
        }

        if(i < length && j+1 < length && checkOutofBounds(j+1) && c[i][j+1] == strs[k+1]){
            stringBuilder.append(i + "," + (j+1) + ",");
            check(i,j+1,k+1);
        }else if (i+1 < length && j < length && checkOutofBounds(i+1) && c[i+1][j] == strs[k+1]){
            stringBuilder.append((i+1) + "," + j + ",");
            check(i+1,j,k+1);
        }else if (i < length && j-1 < length && checkOutofBounds(j-1) && c[i][j-1] == strs[k+1]){
            stringBuilder.append(i + "," + (j-1) + ",");
            check(i,j-1,k+1);
        }else if (i-1 < length && j < length && checkOutofBounds(i-1) && c[i-1][j] == strs[k+1]){
            stringBuilder.append((i-1) + "," + j + ",");
            check(i-1,j,k+1);
        }else{
            flag = false;
            stringBuilder.setLength(0);
        }
    }

    private static boolean checkOutofBounds(int x){
        if (x < 0 || x>= length ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = fun();
        System.out.println(s.substring(0,s.length()-1));
    }
}
