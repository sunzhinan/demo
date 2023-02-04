package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunzhinan
 * @create: 2022-06-29 22:55
 * @description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "hello spring boot!";
    }
}
