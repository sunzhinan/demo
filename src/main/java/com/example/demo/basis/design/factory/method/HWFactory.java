package com.example.demo.basis.design.factory.method;

import com.example.demo.basis.design.factory.simple.HuaWei;
import com.example.demo.basis.design.factory.simple.Phone;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:19
 * @description: 华为手机工厂
 */
public class HWFactory implements PhoneFactory{
    @Override
    public Phone getPhone() {
        return new HuaWei();
    }
}
