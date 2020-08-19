package com.example.demo.basis.design.templatemethod;

/**
 * @author : sun
 * create at:  2020/4/28  22:20
 * @description: 我家建房子
 */
public class MyHouse extends AbstractHouse{
    @Override
    public void getDrawing() {
        System.out.println("这是我家房子的设计图纸");
    }

    @Override
    public void setGround() {
        System.out.println("我开始打地基了");
    }

    @Override
    public void decoration() {
        System.out.println("我家房子建好了，开始装修");
    }

    @Override
    public void success() {
        System.out.println("我入住啦");
    }
}
