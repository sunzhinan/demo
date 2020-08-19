package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:31
 * @description: 支线任务1
 */
public class SubTaskOne implements SubTask{
    @Override
    public void callMe(TaskEvent taskEvent) {
        System.out.println("支线任务1已开启");

        System.out.println("主线任务类型是 : " + taskEvent.taskType + " 已完成");
    }
}
