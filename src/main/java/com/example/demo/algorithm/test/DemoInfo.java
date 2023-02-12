package com.example.demo.algorithm.test;

import lombok.Data;

@Data
public class DemoInfo {
    private String name;

    private String sex;

    private int age;
    public DemoInfo(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
