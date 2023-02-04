package com.example.demo;

import com.example.demo.spring.boot.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: sunzhinan
 * @create: 2022-07-06 22:30
 * @description:
 */
@SpringBootTest
public class PersonTest {

    @Autowired
    Person person;

    @Test
    public void testYaml(){
        System.out.println(person);
    }
}
