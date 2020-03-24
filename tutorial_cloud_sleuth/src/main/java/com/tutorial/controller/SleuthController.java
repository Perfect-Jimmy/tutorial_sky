package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/24
 */
@RestController
public class SleuthController {

    @RequestMapping("/sleuthTest")
    public String sleuthTest(){
        return "sleuth";
    }
}
