package com.tutorial.controller;

import com.tutorial.model.User;
import com.tutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findUserById")
    public void findUserById(Long id){
        User user = userService.findById(id);
        System.out.println(user);
    }
}
