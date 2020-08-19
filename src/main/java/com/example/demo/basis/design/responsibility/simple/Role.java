package com.example.demo.basis.design.responsibility.simple;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 21:48
 * @description: 抽象角色类，提供一个抽象审批方法
 */
public abstract class Role {
    protected Role role;

    /*
        这个方法主要是来提供链条的
     */
    public void setNextRole(Role role) {
        this.role = role;
    }

    /*
        提供一个抽象审批方法
     */
    public abstract boolean approve();
}
