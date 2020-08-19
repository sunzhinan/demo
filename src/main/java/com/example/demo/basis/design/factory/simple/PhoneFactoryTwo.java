package com.example.demo.basis.design.factory.simple;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 21:51
 * @description: 手机工厂二
 */
public class PhoneFactoryTwo {

    public static Phone getAppleInstance(){
        return new Apple();
    }

    public static Phone getHWInstance(){
        return new HuaWei();
    }
}
