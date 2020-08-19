package com.example.demo.basis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: sunzhinan
 * @create: 2020-08-10 22:35
 * @description: 反射测试类
 */
public class TestReflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //通过forName方式
        Class<?> studentClass1 = Class.forName("com.example.demo.basis.reflection.Student");

        //通过.class方式
        Class<Student> studentClass2 = Student.class;

        //通过实例对象getClass()
        Student student = new Student();
        Class<? extends Student> studentClass3 = student.getClass();

        System.out.println(studentClass1);
        System.out.println(studentClass2);
        System.out.println(studentClass3);

        /**
         * 一些方法介绍
         */

        //获得一个新的对象
        Student student1 = studentClass2.newInstance();
        System.out.println(student.equals(student1));

        //获得父类型
        Class superclass = studentClass2.getSuperclass();
        System.out.println(superclass);

        //获得构造函数
        Constructor<?>[] constructors = studentClass1.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }

        //获得指定方法：还可以通过getDeclaredMethods获得所有方法；getMethods只能获得公共的方法
        Method goSchool = studentClass3.getMethod("goSchool");
        System.out.println(goSchool);
        System.out.println(goSchool.getName());
        System.out.println(goSchool.getParameterTypes().length);

        System.out.println("-----------------");
        //获得属性，getFields只能知道public作用域的方法
        Field[] declaredFields = studentClass3.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].getName());
            System.out.println(declaredFields[i].getGenericType().getTypeName());
            System.out.println("++++++++++++++++++++++++");
        }


        //动态创建对象执行方法
        Method goName = studentClass2.getDeclaredMethod("goName", String.class);
        System.out.println("name is : " + student1.getName());
        goName.invoke(student1,"sunzhinan");
        System.out.println("name is : " + student1.getName());

        Field nameField = studentClass2.getDeclaredField("name");

        //默认为false，不能修改私有属性，但是通过设置true，可以设置，需要注意安全问题
        nameField.setAccessible(true);
        nameField.set(student1,"woshishui");
        System.out.println("name is : " + student1.getName());
    }
}