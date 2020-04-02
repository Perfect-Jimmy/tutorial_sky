package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/25
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("java.io.tmpdir"));
        ///var/folders/ws/yvpzm7n56h527s6hq_hd7znh0000gn/T/
    }
}
