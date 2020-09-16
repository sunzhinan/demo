package com.example.demo.basis.alibaba;

/**
 * @author: sunzhinan
 * @create: 2020-09-08 22:36
 * @description: Integer包装类比较
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        // 如果安装了阿里的规范插件，是可以直接检测出的，建议安装
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }
}
