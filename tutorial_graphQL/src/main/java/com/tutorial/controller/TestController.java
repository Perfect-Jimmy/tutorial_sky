package com.tutorial.controller;

import com.tutorial.pojo.Book;
import com.tutorial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2020/4/30
 */
@RestController
public class TestController {
    @Autowired
    BookService bookService;

    @RequestMapping("/findBookById")
    public Book findBookById(@RequestParam(name = "id") Long id){
       // System.out.println(bookService.findById(id)+"-=====");
        return bookService.findById(id);
    }

    @RequestMapping("/save")
    public Book save(){
        Book book = new Book().setName("elasticsearch").setPrice(200D);
        return bookService.saveOrUpdate(book);
    }
}
