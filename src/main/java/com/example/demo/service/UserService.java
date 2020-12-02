package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @author: sunzhinan
 * @create: 2020-12-02 21:16
 * @description: service
 */
public interface UserService {
    List<User> findAll();
}
