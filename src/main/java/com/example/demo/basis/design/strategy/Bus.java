package com.example.demo.basis.design.strategy;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 23:11
 * @description: 具体策略类——公交
 */
public class Bus implements Strategy{
    @Override
    public void goWork() {
        System.out.println("乘坐公交车上班");
    }
}
