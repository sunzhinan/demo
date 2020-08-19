package com.example.demo.spring.aop.annotation;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 13:22
 * @description: 角色
 */
public enum Roles {


    MANAGER("manager"),
    ROOT("root"),
    TOURIST("Tourist"),
    NORMAL("normal");

    private String roleName;

    Roles(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {

        return roleName;
    }
}
