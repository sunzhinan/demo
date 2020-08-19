package com.example.demo.basis.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 18:19
 * @description: 动态代理类
 */
public class ProxyHandler implements InvocationHandler {

    private Object targetObj;

    public Object newProxyInstance(Object targetObj) {
        this.targetObj = targetObj;

        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理开始");
        Object obj = method.invoke(targetObj,args);
        System.out.println("代理结束");
        return obj;
    }
}
