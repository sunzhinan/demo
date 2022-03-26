package com.example.demo.hw;

/**
 * 可信二期21题
 */
public class Test015 {

    private static int index;
    private static int length;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static  boolean flag = true;
    private static char c[][] = {
            {'A','A','C','C','F'},
            {'K','C','D','E','D'},
            {'A','B','E','S','S'},
            {'C','F','E','C','A'},
            {'C','F','E','C','A'}

    };

//    private static char c[][] = {
//            {'A','C','C','F'},
//            {'C','D','E','D'},
//            {'B','E','S','S'},
//            {'F','E','C','A'}
//
//    };
    private static int strLength;
    private static char strs[] ;

    private static String fun(){

        String s = "ACCESS";

        strs = s.toCharArray();

        length = c.length;
        strLength = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(c[i][j] == strs[0]){
                    flag = true;
                    stringBuilder.append(i + "," + j + ",");
                    check(i,j,0);
                    if (stringBuilder.length() > 0){
                        return stringBuilder.toString();
                    }
                }
            }
        }

        return null;
    }

    private static void check(int i,int j,int k){
        if (!flag){
            return;
        }

        index = k+1;
        if (index == strLength){
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
            index = 0;
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
