package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:51
 * @description: Role角色事件类型
 */
public class OneTaskEvent extends TaskEvent<Role>{


    Role role;

    public OneTaskEvent(String taskName, String taskType, Role role) {
        this.taskName = taskName;
        this.taskType = taskType;
        this.role = role;
    }

    @Override
    Role getSource() {
        return this.role;
    }
}
