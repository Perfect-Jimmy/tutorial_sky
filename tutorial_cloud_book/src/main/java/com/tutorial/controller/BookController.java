package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@RestController
public class BookController {

    @RequestMapping("/bookTest")
    public String bookTest(){
        return "book server";
    }
}
