package com.example.demo.basis.design.strategy;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 23:09
 * @description: 具体策略类——私家车
 */
public class Car implements Strategy{

    @Override
    public void goWork() {
        /*
        具体的业务处理逻辑
         */
        System.out.println("自己开车上班");
    }
}
