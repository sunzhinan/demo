package com.example.demo.basis.reflection;

/**
 * @author: sunzhinan
 * @create: 2020-08-10 22:27
 * @description: 学生实体类
 */
public class Student {
    private String name;

    private String address;

    private int age;

    private int no;

    private String sex;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name,int age) {
        this.name = name;
    }

    public void goSchool(){
        String method = "car";
    }

    public static int getScore(){
        int score = 100;

        return score;
    }

    public void goName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
