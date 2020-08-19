package com.example.demo.basis.design.factory.method;

import com.example.demo.basis.design.factory.simple.Phone;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:19
 * @description: 测试类
 */
public class TestFactory {
    public static void main(String[] args) {
        Phone apple = new AppleFactory().getPhone();
        Phone huawei = new HWFactory().getPhone();
        Phone mi = new MIPhoneFactory().getPhone();

        apple.playGame();
        huawei.playGame();
        mi.playGame();
    }
}
