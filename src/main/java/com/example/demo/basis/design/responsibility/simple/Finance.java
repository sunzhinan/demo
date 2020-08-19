package com.example.demo.basis.design.responsibility.simple;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 22:23
 * @description: 财务：继承角色获得审批权限
 */
public class Finance extends Role{
    @Override
    public boolean approve() {
        System.out.println("财务审批！");
        //经过某些处理经理通过（这里当然也可以不通过）
        boolean flag = true;

        return flag;
    }
}
