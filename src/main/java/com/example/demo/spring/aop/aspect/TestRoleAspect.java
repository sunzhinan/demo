package com.example.demo.spring.aop.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.spring.aop.annotation.Authority;
import com.example.demo.spring.aop.annotation.Roles;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 13:24
 * @description: 角色注解切面处理类
 */
@Aspect
@Slf4j
@Component
public class TestRoleAspect {

    @Pointcut("@annotation(com.example.demo.spring.aop.annotation.Authority)")
    private void authority(){}

    @Around(value = "authority()")
    public String advice(ProceedingJoinPoint joinPoint) throws Throwable{

        String response = null;

        // 获得切入的 Method
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        // 获得方法
        Method method = joinPointObject.getMethod();

        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        RequestMethod[] methods =requestMapping.method();

        //我这里为了方便,直接从入参中取出
        Object[] args = joinPoint.getArgs();

        //根据入参形式不同进行取参
//        String params = null;
//        // GET请求
//        if(methods.length > 0 && requestMapping.method()[0] == RequestMethod.GET){
//            params = getRequestParams(method,args);
//        }else{
//            if(args != null && args.length > 0){
//                params = (String) args[0];
//            }
//        }

        // 通过session的方式
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        String role = (String) request.getSession().getAttribute("role");

        Authority annotation = method.getAnnotation(Authority.class);
        Roles[] roles = annotation.role();

        System.out.println("----------------------");

        if ("".equals(args[0])) {
            return "没有权限";
        }

        if (checkRole(roles, (String) args[0])){
            return "没有权限";
        }

        System.out.println("----------------------");

        // 执行切面方法
        try{

            response = (String) joinPoint.proceed();
        }catch (Throwable throwable){

        }

        return response;
    }

    private String getRequestParams(Method requestMethod,Object[] requestArgs){

        String str = "";

        if (requestArgs == null || requestArgs.length == 0){
            return null;
        }

        Annotation[][] paramsAns = requestMethod.getParameterAnnotations();
        if (paramsAns.length > 0){
            for (int i = 0; i < paramsAns.length; i++) {
                Annotation[] paramAns = paramsAns[i];
                if (paramAns != null && paramAns.length > 0){
                    for (int j = 0; j < paramAns.length; j++) {
                        if(paramAns[j] instanceof RequestParam){
                            str = (String) requestArgs[i];
                            break;
                        }
                    }
                }
            }
        }

        return str;

    }

    private static boolean checkRole(Roles[] roles,String role){
        boolean flag = true;
        for (int i = 0; i < roles.length; i++) {
            if (role.equals(roles[i].getRoleName())){
                System.out.println(roles[i]);
                flag = false;
                break;
            }
        }
        return flag;
    }
}
