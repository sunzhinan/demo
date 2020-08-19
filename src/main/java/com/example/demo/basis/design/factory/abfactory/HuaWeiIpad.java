package com.example.demo.basis.design.factory.abfactory;

/**
 * @author: sunzhinan
 * @create: 2020-08-12 22:51
 * @description: 华为平板
 */
public class HuaWeiIpad implements IPad{
    @Override
    public void view() {
        System.out.println("用华为平板看视频");
    }
}
