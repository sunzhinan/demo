package com.example.demo.basis.design.factory.method;

import com.example.demo.basis.design.factory.simple.Phone;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:20
 * @description: 小米手机工厂
 */
public class MIPhoneFactory implements PhoneFactory{
    @Override
    public Phone getPhone() {
        return new Mi();
    }
}
