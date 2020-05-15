package com.tutorial.repository;

import com.tutorial.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author jimmy
 * @date 2020/5/7
 */
@Repository
public class UserRepository {

    public User getUserById(Integer id){
        return new User();
    }

    public Integer insertUser(User user){
        return 1;
    }
}
