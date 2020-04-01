package com.tutorial.controller;

import com.tutorial.feign.BookFeignInterface;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2020/3/31 17:08
 */
@RestController
public class BookFeignController implements BookFeignInterface {
    @Override
    public void getBook() {
        System.out.println("----");
    }
}
