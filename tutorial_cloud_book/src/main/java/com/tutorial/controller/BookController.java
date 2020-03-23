package com.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2020/3/17
 */
@RestController
public class BookController {

    @RequestMapping("/bookTest")
    public String bookTest(){
        System.out.println("AAAAAA");
        return "book server";
    }

    @RequestMapping("/bookFeign")
    public String bookFeign(){
        System.out.println("BBBBBB");
        return "book server";
    }


    @RequestMapping("/getBook")
    public String getBook(@RequestParam(name = "name") String name){
        System.out.println("book name "+name);
        return name;
    }
}
