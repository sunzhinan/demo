package com.example.demo.spring.aop.controller;

import com.example.demo.spring.aop.annotation.Authority;
import com.example.demo.spring.aop.annotation.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 11:26
 * @description: 测试通过注解来实现面向切面编程
 */

@RestController
@Slf4j
public class TestAnnotationController {

    @Authority(role= Roles.ROOT)
    @RequestMapping(value = "/annotation1",method = RequestMethod.GET)
    public String test1(@RequestParam("role") String role){
        log.info("----我来啦 1----");
        return "hello Annotation1!";
    }

    @Authority(role= Roles.TOURIST)
    @RequestMapping(value = "/annotation2",method = RequestMethod.GET)
    public String test2(@RequestParam("role") String role){
        log.info("----我来啦 2----");
        return "hello Annotation2!";
    }

    @Authority(role= {Roles.TOURIST,Roles.MANAGER})
    @RequestMapping(value = "/annotation3",method = RequestMethod.GET)
    public String test3(@RequestParam("role") String role){
        log.info("----我来啦 3----");
        return "hello Annotation3!";
    }
}
