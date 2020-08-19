package com.example.demo.basis.design.observer;

/**
 * @author: sunzhinan
 * @create: 2020-08-11 22:43
 * @description: 测试类
 */
public class Test {
    public static void main(String[] args) {
        Role role = new ProtagonistOne("法师");
        role.putTask(new SubTaskOne());
        role.putTask(new SubTaskTwo());

        role.notifyTask();
    }
}
