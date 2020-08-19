package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 23:01
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        appleFactory.getPhone().playGame();
        appleFactory.getIPad().view();

        System.out.println("------------------");

        huaWeiFactory.getIPad().view();
        huaWeiFactory.getPhone().playGame();

    }
}
