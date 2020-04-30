package com.tutorial.resolver;


import com.tutorial.pojo.Book;
import com.tutorial.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author jimmy
 * @date 2020/4/30
 */
@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
   // @Autowired
    BookRepository bookRepository;

    public Book findById(Long id){
        return bookRepository.getOne(id);
    }
}
