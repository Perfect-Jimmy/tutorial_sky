package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2020/3/25 23:26
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "aa";
    }

}
