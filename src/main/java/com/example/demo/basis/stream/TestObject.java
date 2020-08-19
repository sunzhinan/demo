package com.example.demo.basis.stream;

import lombok.Data;

/**
 * @author: sunzhinan
 * @create: 2020-07-29 20:50
 * @description:
 */
@Data
public class TestObject {
    private String name;

    private int age;

    public TestObject(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
