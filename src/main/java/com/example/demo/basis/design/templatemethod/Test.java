package com.example.demo.basis.design.templatemethod;

/**
 * @author : sun
 * create at:  2020/4/28  22:23
 * @description: 测试模板方法设计模式
 */
public class Test {

    public static void main(String[] args) {
        AbstractHouse house = new MyHouse();
        house.buildHouse();

        System.out.println("------------------------");
        house = new YouHouse();
        house.buildHouse();
    }
}
