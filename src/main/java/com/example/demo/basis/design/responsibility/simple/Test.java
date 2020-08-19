package com.example.demo.basis.design.responsibility.simple;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 22:28
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        Role groupLeader = new GroupLeader();
        Role manager = new Manager();
        Role finance = new Finance();

        //将审批关系关联好
        manager.setNextRole(finance);
        groupLeader.setNextRole(manager);
        //调用第一个角色审批
        boolean approve = groupLeader.approve();
        System.out.println(approve);
    }
}
