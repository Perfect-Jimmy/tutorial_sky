package com.tutorial.repository;

import com.tutorial.model.User;
import com.tutorial.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public User findById(Long id){
        return userMapper.findById(id);
    }
}
