package com.tutorial.resolver;


import com.tutorial.pojo.Book;
import com.tutorial.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 定义数据查询接口
 * @author jimmy
 * @date 2020/4/30
 */
@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
   // @Autowired
   // BookRepository bookRepository;

    public Book findBookById(Long id){
        Book book = new Book();
        book.setId(1L);
        book.setName("java");
        book.setPrice(10D);
        return book;
       // return bookRepository.getOne(id);
    }
}
