package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:33
 * @description: 支线任务2
 */
public class SubTaskTwo implements SubTask{
    @Override
    public void callMe(TaskEvent taskEvent) {
        System.out.println("支线任务2已开启");
        Role source = (Role) taskEvent.getSource();
        System.out.println("主角角色是 : " + source.getRoleType());
        System.out.println("主线任务是 : " + taskEvent.taskName + " 已完成");

    }
}
