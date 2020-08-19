package com.example.demo.basis.base;

/**
 * @author : sun
 * create at:  2020/4/30  22:50
 * @description: 类加载顺序
 */
public class TestLoadOrder {


    public static void main(String[] args) {
        Father father = new Son();
        System.out.println("-----------------------");
        father.m();

//        Father father = new Father();
//        System.out.println("-----------------------");
//        father.m();
//
//
//        System.out.println("**************************");
//        Son son = new Son();
//        System.out.println("-----------------------");
//        son.m();

    }

}


class Father{
    public Father() {
        System.out.println("父类构造函数");
    }

    static {
        System.out.println("父类静态块");
    }

    public void m(){
        System.out.println("父类M方法");
    }
}

class Son extends Father{
    public Son() {
        super();
        System.out.println("子类构造函数");
    }

    static {
        System.out.println("子类静态块");
    }

    @Override
    public void m() {
        System.out.println("子类M方法");

    }
}