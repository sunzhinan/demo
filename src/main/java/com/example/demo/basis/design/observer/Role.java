package com.example.demo.basis.design.observer;

import java.util.ArrayList;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:29
 * @description: 抽象角色类
 */
public abstract class Role {
    String roleType;

    public Role(String roleType) {
        this.roleType = roleType;
    }

    //定义一个集合，里面是存放这个角色有关的支线任务
    public ArrayList<SubTask> subTasksList = new ArrayList<>();

    //添加支线任务的方法
    public void putTask(SubTask subTask){
        subTasksList.add(subTask);
    }

    //子类实现的方法
    public abstract void notifyTask();

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

}
