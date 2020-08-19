package com.example.demo.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 00:57
 * @description: 通过注解方式实现AOP--这里主要讲述他们的简单应用
 */

//标记切面类的处理优先级,值越小,优先级别越高;
//可以注解类,也能注解到方法上
@Order(1)
@Aspect
@Slf4j
//这里有个坑，spring boot扫描不会自动注入@Aspect这个注解的类，所有需要手动加上，
//如果不加就不会进行代理，因为@Aspect只会代理IOC容器内的对象
@Component
public class TestLogAspect {

    //通过切入点:可以通过|| && 方式进行组合
//    @Pointcut("execution(* com.example.demo.spring.aop.service..*.*(..)) " + " || execution(* com.example.demo.spring.aop.service.TestService.query())")
    @Pointcut("execution(* com.example.demo.spring.aop.controller.TestController.*(..))")
    private void beforePointCut(){}

    @Pointcut("execution(* com.example.demo.spring.aop.service..*.*(..))")
    private void afterPointCut(){}

    @Pointcut("execution(* com.example.demo.spring.aop.service.TestService.*(..))")
    private void aroundPointCut(){}


    /**
     * 对于通知Advice也可以自己定义切入点规则,不需要通过自定义切入点
     */
//    @Before("execution(* com.example.demo.spring.aop.controller.TestController.*(..))")
//    @Before("execution(* com.example.demo.spring.aop.service..*.*(..))")
    @Before(value = "beforePointCut()")
    public void logBefore(){
        log.info("方法调用前打印日志");
    }

    /**
     * 最终通知
     */
    @After(value = "afterPointCut()")
    public void logAfter(){
        log.info("方法调用后打印日志");
    }

    /**
     *  aroud和其他的有点区别,他需要在内部调用被代理类的方法
     * @param joinPoint
     * @return
     */
//    @Around(value = "aroundPointCut()")
    @Around(value = "execution(* com.example.demo.spring.aop.controller.TestController.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("----Around----");

        //获得目标对象的class
        Class<?> targetClass = joinPoint.getTarget().getClass();

        //获得方法参数类型
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        //获得目标方法的入参
        Object[] args = joinPoint.getArgs();

        //获得目标对象的方法名字
        String methodName = joinPoint.getSignature().getName();
        Method method = targetClass.getMethod(methodName, parameterTypes);  //获取目标方法


        log.info("我调用的方法名字是 : "+ methodName);
        log.info("method is : " + method);
        for (int i = 0; i < args.length; i++) {
            log.info("方法的参数是 : "+args[i]);
        }
        try {
            //执行目标类方法:这个是核心的
            Object result = joinPoint.proceed();

            //获得方法的执行结果
            log.info("result: " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return "Around";
    }

    /**
     * AfterReturning(后置通知) 会在 After之后执行
     */
    @AfterReturning(pointcut = "afterPointCut() || beforePointCut()")
    public void afterRun(){
        log.info("执行 AfterReturning");
    }

    /**
     * 异常通知
     * 注意: 使用@AfterThrowing与@Around时,这两个advice的切入点不能重合,如何这里@Around的切入点也是afterPointCut(),那么@AfterThrowing不会生效
     */
    @AfterThrowing(throwing="throwable"
            , value="afterPointCut()")
    public void afterThrow(Throwable throwable){
        log.info("执行 ---- AfterThrowing");
    }
}
