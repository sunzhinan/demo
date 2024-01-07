package com.example.demo.domain;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author: sunzhinan
 * @create: 2020-12-02 18:58
 * @description: POJO
 */

@Data
public class User {
    private String id;

    private String name;

    private int age;

    private String address;

    private String phone;

    private String stature;

    public User(){

    }

    public User(String name ,int age){
        this.name = name;
        this.age = age;
    }

    public static ArrayList<User> getUserList(){
        ArrayList<User> list = new ArrayList(8);
        list.add(new User("张三",23));
        list.add(new User("李四",25));
        list.add(new User("王五",18));

        return list;
    }

    @Override
    public String toString(){
        return this.name + " :" + this.age;
    }
}
