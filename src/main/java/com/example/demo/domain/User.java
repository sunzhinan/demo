package com.example.demo.domain;

import lombok.Data;

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
}
