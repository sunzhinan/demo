package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:50
 * @description: 事件——通过泛型可以衍生出不同的角色事件类型
 */
public abstract class TaskEvent<T> {

    String taskName;

    String taskType;

    abstract T getSource();
}
