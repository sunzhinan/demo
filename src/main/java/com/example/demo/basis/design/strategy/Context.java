package com.example.demo.basis.design.strategy;

import lombok.Data;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 23:12
 * @description: 环境类
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void doStrategy(){
        strategy.goWork();
    }
}
