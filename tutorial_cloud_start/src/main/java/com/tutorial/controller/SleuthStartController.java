package com.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jimmy
 * @Date: 2020/3/24
 */
@RestController
public class SleuthStartController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sleuth/sleuthStart")
    public void sleuthTest(){
        //调用book-server
        String method = "bookTest";
        restTemplate.getForEntity("http://spring-cloud-book-server/" + method, String.class).getBody();
    }
}
