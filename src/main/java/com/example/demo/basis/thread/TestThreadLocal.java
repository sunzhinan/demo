package com.example.demo.basis.thread;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : sun
 * create at:  2020/4/29  21:27
 * @description: ThreadLocal 类介绍
 */
public class TestThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<Person> tl = new ThreadLocal<>();
        Person person = new Person();
        person.name = "sunzhinan";
        tl.set(person);

        System.out.println(tl.get().getName());

        //这里一定要记住要remove，不然会出现内存泄漏
        tl.remove();

    }

}

@Getter
@Setter
class Person{
    public String name;
}
