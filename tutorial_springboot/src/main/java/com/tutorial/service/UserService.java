package com.tutorial.service;

import com.tutorial.entity.User;
import com.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jimmy
 * @date 2020/5/7
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    public Integer insertUser(User user) {
        return userRepository.insertUser(user);
    }
}
