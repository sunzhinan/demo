package com.example.demo.basis.design.responsibility.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sunzhinan
 * @create: 2020-07-31 23:32
 * @description: 这个类至关重要，这个类是实际调用各个具体责任类
 */
public class ChainRole {
    //list里面存放具体责任类对象
    List<Role> list = new ArrayList<>();
    //index从0开始，当所有具体责任类完成操作，它控制了这个链条结束标识（仔细阅读这个链条，你可以发现它是一个递归）
    int index = 0;

    //增加具体责任类方法，因为list是有序的，所有可以根据index，逐个执行，保证顺序
    public ChainRole add(Role role){
        list.add(role);
        return this;
    }

    //核心方法：他主要是判断这个递归深度，控制其返回；同时它也是开始的起点
    public boolean excute(Request request,Response response){
        if(list.size() == index)
        {
            return false;
        }
        //这个role在每次外部调用excute方法后都是根据当前index值来获得的具体责任类
        Role role = list.get(index);
        index++;
        return role.approve(request,response,this);
    }

}
