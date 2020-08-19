package com.example.demo.basis.design.templatemethod;

/**
 * @author : sun
 * create at:  2020/4/28  22:24
 * @description: 他家的房子
 */
public class YouHouse extends AbstractHouse{
    @Override
    public void getDrawing() {
        System.out.println("他家开始设计房子图纸了");
    }

    @Override
    public void setGround() {
        System.out.println("他家开始建房子了");
    }

    @Override
    public void decoration() {
        System.out.println("他家房子建好开始装修了");
    }

    @Override
    public void success() {
        System.out.println("他住进新家了");
    }
}
