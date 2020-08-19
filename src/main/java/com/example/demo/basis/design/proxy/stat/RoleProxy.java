package com.example.demo.basis.design.proxy.stat;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 18:03
 * @description: 代理类
 */
public class RoleProxy implements Role{
    private Role role;

    public RoleProxy(Role role) {
        this.role = role;
    }

    public void getGift(){
        System.out.println("代理开始");
        role.getGift();
        System.out.println("代理结束");
    }
}
