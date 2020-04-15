package com.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2020/3/25 23:26
 */
@RestController
public class TestController {
    @Value("${thread.task.pool.corePoolSize}")
    private int poolSize;


    @RequestMapping("/test")
    public String test(){
        System.out.println("-====="+poolSize);
        return "aa";
    }

}
