package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/23
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallBack")
    public String fallback() {
        return "I'm Spring Cloud Gateway fallback.";
    }
}
