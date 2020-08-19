package com.example.demo.spring.aop.service.impl;

import com.example.demo.spring.aop.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: sunzhinan
 * @create: 2020-08-09 00:59
 * @description: 业务实现类
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public void add(int i,String name) {
        log.info("----------------------------");
        log.info("新增方法实现功能    " + i + "      " + name);
        log.info("----------------------------");
    }

    @Override
    public String query(String id){
        log.info("----------------------------");
        log.info("查询方法实现功能    " + id );
        log.info("----------------------------");

        //测试异常通知
//        if(true){
//            log.info("-----异常----");
//            throw new ArrayIndexOutOfBoundsException("数组越界");
//        }

        return "21545";
    }
}
