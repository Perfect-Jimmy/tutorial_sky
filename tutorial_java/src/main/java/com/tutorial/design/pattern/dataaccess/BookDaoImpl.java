package com.tutorial.design.pattern.dataaccess;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类负责从数据源获取数据，数据源可以是数据库，也可以是 xml，或者是其他的存储机制。
 * @author jimmy
 * @date 2020/7/19
 */
public class BookDaoImpl implements BookDao {
    //模拟数据库
    List<Book> list;
    public BookDaoImpl(){
        list = new ArrayList<>();
        Book book1 = new Book(1L,"Java");
        Book book2 = new Book(2L,"elasticsearch");
        list.add(book1);
        list.add(book2);
    }

    @Override
    public List<Book> getAll() {
        return list;
    }

    @Override
    public Book saveBook(Book book) {
        list.add(book);
        return book;
    }

    @Override
    public void delBook(Long id) {

    }
}
