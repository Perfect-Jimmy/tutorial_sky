package com.tutorial.controller;

import com.tutorial.feign.service.BookFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/18
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private BookFeignService bookFeignService;

    @RequestMapping("/feignCall")
    public String feignCall() {
        String message = bookFeignService.bookFeign();
        return "获取到的信息:" + message;
    }
}
