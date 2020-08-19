package com.example.demo.basis.design.responsibility.simple;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 22:18
 * @description: 经理：继承角色获得审批权限
 */
public class Manager extends Role{
    @Override
    public boolean approve() {
        System.out.println("经理审批！");
        //经过某些处理经理通过（这里当然也可以不通过）
        boolean flag = true;

        //这里加上flag主要是为了判断，当然实际是不需要加的，因为如果上面某些判断结果为false那可能直接返回了
        if(flag && role != null){
            return role.approve();
        }
        return flag;
    }
}
