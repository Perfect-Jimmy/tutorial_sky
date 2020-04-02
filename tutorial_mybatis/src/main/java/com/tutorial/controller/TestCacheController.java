package com.tutorial.controller;

import com.tutorial.model.User;
import com.tutorial.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2020/4/2 15:50
 */
@RestController
public class TestCacheController {
    @Autowired
    private UserCacheService userCacheService;

    @RequestMapping("/cacheGetUser")
    public Object getUser(Long id){
        User user = userCacheService.findById(id);
        return user;
    }
}
