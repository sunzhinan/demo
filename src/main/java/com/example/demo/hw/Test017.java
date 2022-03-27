package com.example.demo.hw;

import java.util.Scanner;

/**
 * 可信二期23题
 */
public class Test017 {

    private static String[] strs1 ;
    private static String[][] strs;
    private static int length = 1 ;
    private static int moveIndex = 0;
    // 方向
    private static String direction;

    private static int x = 0;
    private static int y = 0;

    private static int maxX = 0;
    private static int maxY = 0;

    // 蛇身体部分
    private static StringBuilder stringBuilder = new StringBuilder();

    private static boolean flag = true;

    private static int fun(){
        Scanner scanner = new Scanner(System.in);
        // 步骤，空格分割
        String s1 = scanner.nextLine();
        strs1 = s1.split(" ");
        // 二维数组长度和宽度，空格分割
        String s2 = scanner.nextLine();
        String[] s3 = s2.split(" ");
        maxX = Integer.parseInt(s3[1]) - 1;
        maxY = Integer.parseInt(s3[0]) - 1;
        // 二维数组
        strs = new String[Integer.parseInt(s3[0])][Integer.parseInt(s3[1])];
        int k = Integer.parseInt(s3[0]);
        int index = 0;
        // 这里判断可以优化为一个变量index
        while (k > 0 ){
            strs[index] = scanner.nextLine().split(" ");
            k--;
            index++;
        }
        scanner.close();

        boolean flag = false;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
                if(strs[i][j].equals("H")){
                    x = i;
                    y = j;
                    flag = true;
                    stringBuilder.append(i + "," + j + ";");
                    break;
                }
            }

            if (flag){
                break;
            }
        }
        move();

        return length;
    }

    private static void move(){

        if (!flag){
            return;
        }

        if(x< 0 || x > maxX || y < 0 || y > maxY){
            return;
        }

        if (moveIndex + 1 == strs1.length){
            return;
        }

        if(strs1[moveIndex].equals("U")){
            // 向上移动
            direction = "U";
        }else if(strs1[moveIndex].equals("D")){
            // 向下移动
            direction = "D";
        }else if(strs1[moveIndex].equals("L")){
            // 向左移动
            direction = "L";
        }else if(strs1[moveIndex].equals("R")){
            // 向右移动
            direction = "R";
        }else if(moveIndex == 0 && strs1[moveIndex].equals("G")){
            direction = "L";
        }

        if (strs1[moveIndex].equals("G")){
            if(direction.equals("U")){
                x = x - 1;
                if (strs[x][y].equals("F")){
                    strs[x][y] = "E";
                    String xy = x + "," + y ;
                    if(stringBuilder.toString().contains(xy)){
                        flag = false;
                        return;
                    }else {
                        stringBuilder.append(x + "," + y + ";");
                        length++;
                    }
                }

            }else if (direction.equals("D")){
                x = x + 1;
                if (strs[x][y].equals("F")){
                    strs[x][y] = "E";
                    String xy = x + "," + y ;
                    if(stringBuilder.toString().contains(xy)){
                        flag = false;
                        return;
                    }else {
                        stringBuilder.append(x + "," + y + ";");
                        length++;
                    }

                }

            }else if (direction.equals("L")){
                y = y - 1;
                if (strs[x][y].equals("F")){
                    strs[x][y] = "E";
                    String xy = x + "," + y ;
                    if(stringBuilder.toString().contains(xy)){
                        flag = false;
                        return;
                    }else {
                        stringBuilder.append(x + "," + y + ";");
                        length++;
                    }

                }

            }else if (direction.equals("R")){
                y = y + 1;
                if (strs[x][y].equals("F")){
                    strs[x][y] = "E";
                    String xy = x + "," + y ;
                    if(stringBuilder.toString().contains(xy)){
                        flag = false;
                        return;
                    }else{
                        stringBuilder.append(x + "," + y + ";");
                        length++;
                    }

                }
            }
        }
        moveIndex++;
        move();
    }

    public static void main(String[] args) {

        System.out.println(fun());
    }
}
