package com.example.demo.basis.design.strategy;

/**
 * @author: sunzhinan
 * @create: 2020-05-27 22:51
 * @description: 策略模式:接口或者抽象类抽象出行为，这里建议使用接口
 * 我们以上班举例，比如我们早上上班，每个人的出行方式不同，所以会衍生出各种具体策略类
 */
public interface Strategy {
    /**
     * 首先我们抽象出上班这个动作
     */
    void goWork();
}
