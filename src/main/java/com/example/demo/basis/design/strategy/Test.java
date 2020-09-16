package com.example.demo.basis.design.strategy;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 23:14
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context(new Car());
        context.doStrategy();

        context.setStrategy(new Bus());
        context.doStrategy();

        context.setStrategy(new Metro());
        context.doStrategy();
    }
}
