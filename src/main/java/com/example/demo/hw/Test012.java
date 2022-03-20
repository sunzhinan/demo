package com.example.demo.hw;

/**
 * 某探险队负责对地下洞穴进行探险。 探险队成员在进行探险任务时，随身携带的记录器会不定期地记录自身的坐标，但在记录的间隙中也会记录其他数据。 探索工作结束后，探险队需要获取到某成员在探险过程中相对于探险队总部的最远的足迹位置。
 *
 * 仪器记录坐标时，坐标的数据格式为(x,y)，如(1,2)、(100,200)，其中0<x<1000，0<y<1000。同时存在非法坐标，如(01,1)、(1,01)，(0,100)属于非法坐标。
 * 设定探险队总部的坐标为(0,0)，某位置相对总部的距离为：x * x+ y * y。
 * 若两个座标的相对总部的距离相同，则第一次到达的坐标为最远的足迹。
 * 若记录仪中的坐标都不合法，输出总部坐标（0,0）。 备注：不需要考虑双层括号嵌套的情况，比如sfsdfsd((1,2))。
 */
public class Test012 {

    public static String fun(String str){
        String a = str.replaceAll("\\(" , "\\#");
        String b = a.replaceAll("\\)" , "\\#");

        String[] c = b.split("#");

        int k = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < c.length; i++) {

            if(c[i].contains(",")){

                String[] d = c[i].split(",");
                if(d[0].startsWith("0") || d[1].startsWith("0")){
                    continue;
                }
                int n = Integer.parseInt(d[0]);
                int m = Integer.parseInt(d[1]);

                if(n <1000 && 0 < n && m <1000 && 0 < m ){
                    int f = n*n + m*m;
                    if(f > k){
                        k = f;
                        x = n;
                        y = m;
                    }
                }
            }

        }
        return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {
        System.out.println(fun("asfefaweawfaw(0,1)fe"));
    }
}
