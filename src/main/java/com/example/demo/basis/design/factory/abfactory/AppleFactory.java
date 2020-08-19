package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:54
 * @description: 苹果工厂
 */
public class AppleFactory extends MyFactory{
    @Override
    public Phone getPhone() {
        return new Apple();
    }

    @Override
    public IPad getIPad() {
        return new AirPad();
    }
}
