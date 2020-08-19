package com.example.demo.spring.aop.controller;

import com.example.demo.spring.aop.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 00:56
 * @description: 控制器
 */

@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1(){
        System.out.println("test");

        System.out.println("----开始调用add方法----");
        testService.add(27,"sunzhinan");
        System.out.println("----调用add方法结束----");
        return "hello world!";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){

        System.out.println("----开始调用query方法----");

        try {
            testService.query("sunzhinan");
        } catch (Exception e) {
            log.info("Controller 捕获异常");
        }
        System.out.println("----调用query方法结束----");
        return "hello world!";
    }
}
