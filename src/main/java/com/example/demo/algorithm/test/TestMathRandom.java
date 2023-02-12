package com.example.demo.algorithm.test;

/**
 * @author: sunzhinan
 * @create: 2022-04-04 16:13
 * @description: 测试Math.random
 */
public class TestMathRandom {
    public static void main(String[] args) {
        int num = 10000000;
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < num; i++) {
            if (fun4() == 0){
                count0++;
            }
            if (fun4() == 1){
                count1++;
            }
        }
        System.out.println((double) count0 / (double) num);
        System.out.println((double) count1 / (double) num);


        System.out.println("============");
        int[] array = new int[10];
        for (int i = 0; i < num; i++) {
            if(fun7()== 23){
                array[0]++;
            }

            if(fun7()== 24){
                array[1]++;
            }

            if(fun7()== 34){
                array[2]++;
            }

            if(fun7()== 33){
                array[3]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(array[i]);
        }

        System.out.println("============");

        int j = 0;
        for (int i = 0; i < num; i++) {
            if (fun8() == 1){
                j++;
            }
        }
        System.out.println((double) j / (double) num);
    }

    /**
     *  任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原先的x调整成x平方
     */
    private static double fun1(){
        return Math.max(Math.random(),Math.random());
    }

    /**
     * 等概率返回0和1
     * @return
     */
    private static int fun2(){
        return (int) (Math.random()*2);
    }

    /**
     * 等概率返回0到7
     * @return
     */
    private static int fun3(){
        return (fun2() << 2) + (fun2() << 1) + fun2();
    }

    /**
     * 等概率返回0～6
     * @return
     */
    private static int fun4(){
        int i = fun3();
        while (i == 7){
            i = fun3();
        }
        return i;
    }

    /**
     * 等概率返回1～7
     * @return
     */
    private static int fun5(){
        int i = fun3();
        while (i == 0){
            i = fun3();
        }
        return i;
    }

    /**
     * 等概率返回23～34
     */
    private static int fun6(){
        int i = (fun2() << 6) + (fun2() << 5) + (fun2() << 4) + (fun2() << 3) + (fun2() << 2) + (fun2() << 1) + fun2();
        while(i < 23 || i > 34){
            i = (fun2() << 6) + (fun2() << 5) + (fun2() << 4) + (fun2() << 3) + (fun2() << 2) + (fun2() << 1) + fun2();
        }
        return i;
    }

    /**
     * 等概率返回23～34,运算效率远大于fun6
     */
    private static int fun7(){
        int i =  (fun2() << 4) + (fun2() << 3) + (fun2() << 2) + (fun2() << 1) + fun2();
        while(i > 11){
            i = (fun2() << 4) + (fun2() << 3) + (fun2() << 2) + (fun2() << 1) + fun2();
        }
        return i + 23;
    }

    /**
     * 如何通过其他等概率发生器获得0 1等概率发生器
     * @return
     */
    private static int fun8(){
        return fun9() < 4 ? 0 : 1;
    }

    /**
     * 0-7等概率返回
     * @return
     */
    private static int fun9(){
        return (int) (Math.random()*8);
    }
}
