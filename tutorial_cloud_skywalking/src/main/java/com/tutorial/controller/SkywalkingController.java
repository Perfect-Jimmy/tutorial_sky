package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@RestController
public class SkywalkingController {

    @RequestMapping("/skywalkingTest")
    public String skywalkingTest(){
        return "sky walking";
    }
}
