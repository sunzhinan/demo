package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:58
 * @description: 华为工厂
 */
public class HuaWeiFactory extends MyFactory{
    @Override
    public Phone getPhone() {
        return new HuaWei();
    }

    @Override
    public IPad getIPad() {
        return new HuaWeiIpad();
    }
}
