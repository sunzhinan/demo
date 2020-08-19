package com.example.demo.basis.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: sunzhinan
 * @create: 2020-08-02 00:54
 * @description: HashMap遍历方式介绍
 */
public class TestHashMap {

    private static HashMap<String,String> map = new HashMap<>();

    static {
        map.put("name", "sunzhinan");
        map.put("age", "64");
        map.put("mail", "xxxx@163.com");
    }

    /**
     * foreach——entrySet方式
     */
    public static void traverse1(){
        // 遍历
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        }
    }

    /**
     * foreach——keySet方式
     */
    public static void traverse2(){
        // 遍历
        for (String key : map.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + map.get(key));
        }
    }

    /**
     * Iterator——keySet方式
     */
    public static void traverse3(){
        Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        }
    }

    /**
     * Iterator——keySet方式
     */
    public static void traverse4(){
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key : " + key);
            System.out.println("value : " + map.get(key));
        }
    }

    /**
     * Stream——stream()方法
     */
    public static void traverse5(){
        System.out.println("---- 1 ----");
        map.entrySet().stream().forEach((entry)->{
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        });
        System.out.println("---- 2 ----");
        map.keySet().stream().forEach((key)->{
            System.out.println("key : " + key);
            System.out.println("value : " + map.get(key));
        });
    }

    /**
     * Stream——parallelStream()方法
     */
    public static void traverse6(){
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        });
    }

    /**
     * Lambda表达式——JDK8推荐
     */
    public static void traverse7(){
        map.forEach((key,value)->{
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
    }

    public static void main(String[] args) {
        System.out.println("---- ForEach entrySet ----");
        traverse1();
        System.out.println("---- ForEach keySet ----");
        traverse2();
        System.out.println("---- Iterator entrySet ----");
        traverse3();
        System.out.println("---- Iterator keySet ----");
        traverse4();
        System.out.println("---- Stream stream ----");
        traverse5();
        System.out.println("---- Stream parallelStream ----");
        traverse6();
        System.out.println("---- Lambda表达式 ----");
        traverse7();
    }
}
