package com.example.demo.spring.boot;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: sunzhinan
 * @create: 2022-07-06 22:27
 * @description: 演示
 */

@ConfigurationProperties("person")
@Component
@Data
@ToString
public class Person {
    private String name;
    private String age;
    private List<String> likes;
}
