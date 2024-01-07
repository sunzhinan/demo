package com.example.demo.basis.base;

import com.example.demo.domain.User;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sunzhinan
 * @create: 2023-08-30 21:43
 * @description:
 */
public class TestLambda {
    public static void main(String[] args) {
        ArrayList<User> list = User.getUserList();

        list.forEach(item -> {
            System.out.println(item.getName());
        });

        list.forEach(user -> {
            System.out.println(user.toString());
        });

        System.out.println("---------------");

        // 按照属性过滤
        List<User> userList =list.stream().filter(user -> user.getAge() < 20).collect(Collectors.toList());
        userList.forEach(user -> {
            System.out.println(user.toString());
        });

        System.out.println("---------------");
        List<String> strList = ImmutableList.of("abc","edf","sfc");
        strList.forEach(s -> {
            System.out.println(s);
        });
    }
}
