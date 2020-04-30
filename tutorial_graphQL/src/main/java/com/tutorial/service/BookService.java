package com.tutorial.service;

import com.tutorial.pojo.Book;
import com.tutorial.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jimmy
 * @date 2020/4/30
 */
@Service
public class BookService {
    @Resource
    private BookRepository bookRepository;

    public Book findById(Long id){
        return bookRepository.getOne(id);
    }

    public Book saveOrUpdate(Book book){
        return bookRepository.save(book);
    }
}
