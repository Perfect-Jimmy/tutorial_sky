package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    public void test(){
        System.out.println("success");
    }
}
