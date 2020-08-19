package com.example.demo.basis.design.factory.simple;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 21:45
 * @description: 手机工厂一
 */
public class PhoneFactoryOne {

    public static Phone getInstance(String phoneName){

        if("Apple".equals(phoneName)){
            return new Apple();
        }else if ("HW".equals(phoneName)){
            return new HuaWei();
        }else{
            System.out.println("其他手机打不了游戏");
            return null;
        }
    }
}
