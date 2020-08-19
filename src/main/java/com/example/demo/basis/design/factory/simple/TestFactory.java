package com.example.demo.basis.design.factory.simple;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 21:48
 * @description: 测试类
 */
public class TestFactory {
    public static void main(String[] args) {
        PhoneFactoryOne.getInstance("Apple").playGame();
        PhoneFactoryOne.getInstance("HW").playGame();

        System.out.println("--------------------");

        PhoneFactoryTwo.getAppleInstance().playGame();
        PhoneFactoryTwo.getHWInstance().playGame();
    }
}
