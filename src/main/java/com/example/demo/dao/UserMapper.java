package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: sunzhinan
 * @create: 2020-12-02 21:05
 * @description: dao
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
}
