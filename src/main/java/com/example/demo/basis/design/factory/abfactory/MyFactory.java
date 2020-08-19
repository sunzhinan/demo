package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:55
 * @description: 抽象工厂类
 */
public abstract class MyFactory {

    public abstract Phone getPhone();

    public abstract IPad getIPad();
}
