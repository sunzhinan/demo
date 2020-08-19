package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:39
 * @description: 主角1
 */
public class ProtagonistOne extends Role{
    public ProtagonistOne(String roleType) {
        super(roleType);
    }

    @Override
    public void notifyTask() {
        System.out.println("-----开启支线任务-----");
        OneTaskEvent oneTaskEvent = new OneTaskEvent("主线任务1", "kill boss", this);
        for ( SubTask subTask : subTasksList) {
            subTask.callMe(oneTaskEvent);
        }
    }
}
