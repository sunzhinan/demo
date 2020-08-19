package com.example.demo.basis.design.responsibility.simple;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 21:49
 * @description: 组长：继承角色获得审批权限
 */
public class GroupLeader extends Role{

    @Override
    public boolean approve() {
        System.out.println("组长审批！");
        //经过某些处理组长通过（这里当然也可以不通过）
        boolean flag = true;
        if(flag && role != null){
            return role.approve();
        }
        return flag;
    }
}
