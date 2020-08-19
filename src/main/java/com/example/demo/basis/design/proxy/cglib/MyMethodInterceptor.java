package com.example.demo.basis.design.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: sunzhinan
 * @create: 2020-08-08 21:45
 * @description: 代理类
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理开始！");
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("代理结束！");
        return object;
    }
}
