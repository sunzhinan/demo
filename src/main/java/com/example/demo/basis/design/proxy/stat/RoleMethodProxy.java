package com.example.demo.basis.design.proxy.stat;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 18:48
 * @description: 代理类
 */
public class RoleMethodProxy implements Role{
    private Role role;

    public RoleMethodProxy(Role role) {
        this.role = role;
    }
    @Override
    public void getGift() {
        System.out.println("新的代理开始");
        role.getGift();
        System.out.println("新的代理结束");
    }
}
