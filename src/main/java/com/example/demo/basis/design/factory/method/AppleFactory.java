package com.example.demo.basis.design.factory.method;

import com.example.demo.basis.design.factory.simple.Apple;
import com.example.demo.basis.design.factory.simple.Phone;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:08
 * @description: 苹果手机工厂
 */
public class AppleFactory implements PhoneFactory{
    @Override
    public Phone getPhone() {
        return new Apple();
    }
}
