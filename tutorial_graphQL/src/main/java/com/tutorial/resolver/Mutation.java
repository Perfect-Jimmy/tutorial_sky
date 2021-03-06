package com.tutorial.resolver;


import com.tutorial.pojo.Book;
import com.tutorial.repository.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 定义数据增删改接口
 * @author jimmy
 * @date 2020/4/30
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    BookRepository bookRepository;

    public Book saveBook(String name,Double price) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        return bookRepository.save(book);
    }
}
