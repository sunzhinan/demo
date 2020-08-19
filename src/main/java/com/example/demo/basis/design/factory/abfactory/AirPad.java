package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:50
 * @description: 苹果平板电脑
 */
public class AirPad implements IPad{
    @Override
    public void view() {
        System.out.println("用苹果电脑看电视");
    }
}
