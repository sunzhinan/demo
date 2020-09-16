package com.example.demo.basis.design.strategy;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 23:10
 * @description: 具体策略类——地铁
 */
public class Metro implements Strategy{
    @Override
    public void goWork() {
        System.out.println("乘坐地铁上班");
    }
}
