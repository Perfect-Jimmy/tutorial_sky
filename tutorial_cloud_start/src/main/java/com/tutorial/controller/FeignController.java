package com.tutorial.controller;

import com.tutorial.feign.service.BookFeignHystrixService;
import com.tutorial.feign.service.BookFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired(required = false)
    private BookFeignService bookFeignService;
    @Autowired
    private BookFeignHystrixService bookFeignHystrixService;

    @RequestMapping("/feignCall")
    public String feignCall() {
        String message = bookFeignService.bookFeign();
        return "获取到的信息:" + message;
    }


    /**
     * feign hystrix 熔断
     */
    @GetMapping(value = "/feignHystrixCall")
    public String feignHystrixCall(){
        return bookFeignHystrixService.bookFeign();
    }

}
