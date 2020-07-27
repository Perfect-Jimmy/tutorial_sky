package com.tutorial.design.pattern.dataaccess;

import java.util.List;

/**
 *  定义标准操作
 * @author jimmy
 * @date 2020/7/19
 */
public interface BookDao {
    /**
     * 获取所有
     * @return java.util.List<com.tutorial.design.pattern.dataaccess.Book>
     * @author jimmy
     * @date 2020/7/19
     */
    public List<Book> getAll();

    /**
     * 保存
     * @return com.tutorial.design.pattern.dataaccess.Book
     * @author jimmy
     * @date 2020/7/19
     */
    public Book saveBook(Book book);

    /**
     * 删除
     * @return void
     * @author jimmy
     * @date 2020/7/19
     */
    public void delBook(Long id);

}
