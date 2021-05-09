package com.example.demo.basis.alibaba;

import lombok.Data;

/**
 * @author: sunzhinan
 * @create: 2020-12-26 14:35
 * @description: list类型的集合说明:这里演示equals和hashCode方法的使用
 */
@Data
public class ListTest {

    // 假设number是唯一标识
    private int number;

    private String name;

    private int age;

    @Override
    public int hashCode() {
        // 这里仿照HashMap重写hashCode方法
        int h;
        return (this.age == 0) ? 0 : (h = this.age) ^ (h >>> 16);
    }

    @Override
    public boolean equals(Object obj) {
        // 这里仿照String来重写equals方法
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListTest) {
            ListTest anotherObj = (ListTest)obj;
            int number = anotherObj.getNumber();
            if (this.number == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListTest test1 = new ListTest();
        test1.setNumber(111);
        test1.setName("xiaoming");
        test1.setAge(23);

        ListTest test2 = new ListTest();
        test2.setNumber(111);
        test2.setName("xiaoli");
        test2.setAge(24);

        ListTest test3 = new ListTest();
        test3.setNumber(222);
        test3.setName("xiaoming");
        test3.setAge(23);

        System.out.println(test1.equals(test2));
        System.out.println(test1.equals(test3));
        System.out.println("------------");
        System.out.println(test1.hashCode() == test2.hashCode());
        System.out.println(test1.hashCode() == test3.hashCode());
    }
}
