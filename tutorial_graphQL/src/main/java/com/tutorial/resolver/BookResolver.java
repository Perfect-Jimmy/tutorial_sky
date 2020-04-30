package com.tutorial.resolver;


import com.tutorial.pojo.Book;
import com.tutorial.repository.BookRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author jimmy
 * @date 2020/4/30
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {
    BookRepository bookRepository;

    public Book findBookById(Long id){
        return bookRepository.getOne(id);
    }
}
